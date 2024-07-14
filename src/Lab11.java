/*import java.util.*;

public class CourseGradebook extends Gradebook {
   private HashMap<String, HashMap<Integer, Double>> gradebookData;
	protected int field;
	
	public CourseGradebook() {
        gradebookData = new HashMap<>();
    }
	
	@Override
	public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
		if (gradebookData.containsKey(assignmentName)) {
            return gradebookData.get(assignmentName);
      }
      
		return new HashMap<Integer, Double>();
	}
	
	@Override
	public double getScore(String assignmentName, Integer studentID) {
		if (gradebookData.containsKey(assignmentName)) {
            HashMap<Integer, Double> assignmentScores = gradebookData.get(assignmentName);
            
            if (assignmentScores.containsKey(studentID)) {
                return assignmentScores.get(studentID);
            }
      }
      
		return Double.NaN;
	}
	
	@Override
	public ArrayList<String> getSortedAssignmentNames() {
		TreeSet<String> assignmentNamesSet = new TreeSet<>(gradebookData.keySet());
      //return new ArrayList<>(assignmentNamesSet);
		//return new ArrayList<String>();
		return new ArrayList<>(assignmentNamesSet);
	}
	
	@Override
	public ArrayList<Integer> getSortedStudentIDs() {
		TreeSet<Integer> studentIDs = new TreeSet<>();
		
      for (HashMap<Integer, Double> scores : gradebookData.values()) {
         studentIDs.addAll(scores.keySet());
      }
		//return new ArrayList<Integer>();
		return new ArrayList<>(studentIDs);
	}

	@Override
	public HashMap<String, Double> getStudentScores(Integer studentID) {
		HashMap<String, Double> studentScores = new HashMap<>();
		
      for (String name : gradebookData.keySet()) {
         HashMap<Integer, Double> scores = gradebookData.get(name);
         if (scores.containsKey(studentID)) {
             studentScores.put(name, scores.get(studentID));
         }
      }
		//return new HashMap<String, Double>();
		return studentScores;
	}

	@Override
	public void setScore(String assignmentName, Integer studentID, Double score) {
		if (!gradebookData.containsKey(assignmentName)) {
         gradebookData.put(assignmentName, new HashMap<>());
      }
      
      gradebookData.get(assignmentName).put(studentID, score);
	}
}*/
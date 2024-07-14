# Course Gradebook

## Inspect the Gradebook abstract base class

The read-only Gradebook.java file has a declaration for the Gradebook abstract base class.

The Gradebook class stores a collection of entries for a course. Conceptually, a gradebook entry is a (assignment name, student ID, score) triplet. Each assignment name is a String, each student ID an Integer, and each score is a Double. A score is entered into the gradebook via the setScore() method.

The Gradebook class has six methods that must be implemented in an inheriting class.

## Add fields to CourseGradebook class

The CourseGradebook class inherits from Gradebook and is declared in CourseGradebook.java. Inspect each method that must be implemented. 

## Implement CourseGradebook's setScore() and getScore() methods

Implement the setScore() method to enter a single entry into the gradebook. setScore() has parameters for the assignment name, student ID, and score. How the entry is stored depends on the fields chosen

Implement the getScore() method to get a single score from the gradebook. getScore() has parameters for the assignment name and student ID, and returns a Double for the corresponding score. NaN is returned if no such entry exists in the gradebook.

Code in LabProgram.java calls testGetScoreAndSetScore() to test both methods. Run your program in develop mode and ensure that the test passes before proceeding further.

## Implement the remaining CourseGradebook methods

Implement the remaining methods according to the specifications below.
- getAssignmentScores() takes a String for the assignment name and returns a HashMap that maps a student ID to the student's corresponding score for the assignment. An entry exists in the returned map only if a score has been entered with the setScore() method. An empty map is returned if no such assignment exists in the grade book.
- getSortedAssignmentNames() returns an ArrayList with all distinct assignment names, sorted in ascending order.
- getSortedStudentIDs() returns an ArrayList with all distinct student IDs, sorted in ascending order.
- getStudentScores() gets all scores that exist in the gradebook for the student whose ID equals the method parameter. Scores are returned as a HashMap that maps an assignment name to the student's corresponding score for that assignment.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Name: Faruk
//Surname: KAPLAN
//Student ID: 21050111026

class Earthquake {
	private String location;
	private String date; 
	private String time; 
	private double magnitude;
	private double depth;
	public Earthquake next;
	public Earthquake prev;

	public Earthquake(String location, String date, String time, double magnitude, double depth) {
		this.location = location;
		this.date = date;
		this.time = time;
		this.magnitude = magnitude;
		this.depth = depth;
		prev = null;
		next = null;
	}

	public String getLocation() {
		return location;
	}
	public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

	public double getMagnitude() {
        return magnitude;
    }

    public double getDepth() {
        return depth;
    }

    public Earthquake getPrev() {
        return prev;
    }

	public Earthquake getNext() {
        return next;
    }

	public void setPrev(Earthquake newPrev) {
        prev = newPrev;
    }

	public void setNext(Earthquake newNext) {
        next = newNext;
    }
	
}


class EarthquakeLinkedList {
	private Earthquake head;
	private Earthquake tail;
	public Earthquake printList;
	private int size;

	public EarthquakeLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addInput(String location, String date, String time, double magnitude, double depth) {
		Earthquake node = new Earthquake(location, date, time, magnitude, depth);

		if(size == 0) {
			head = node;
			tail = node;
		} else {
			head.setNext(node);
			node.setPrev(head);
			head = node;
		}

		size++;
	}

    public void addQuerie(String location, String date, String time, double magnitude, double depth) {
		Earthquake node = new Earthquake(location, date, time, magnitude, depth);

		tail.setPrev(node);
		node.setNext(tail);
		tail = node;
		
		size++;
	}
    
	public void deleteQuerie(String location, String date, String time, double magnitude, double depth) {
		Earthquake sweep = tail;
		
		while(sweep != null) {
			if(sweep.getLocation().equals(location) && sweep.getDate().equals(date) && sweep.getTime().equals(time) 
			&& (sweep.getMagnitude() == magnitude) && (sweep.getDepth() == depth)) {
		
			    if (sweep == tail) {
			    	tail = sweep.getNext();
			    } else {
			    	sweep.getPrev().setNext(sweep.getNext());
			    }
			    if (sweep == head) {
			    	head = sweep.getPrev();
			    } else {
			    	sweep.getNext().setPrev(sweep.getPrev());
			    }
			    sweep = null;

	            size--;
	            break;
			}	
			sweep = sweep.getNext();
		}
	}

	public int getSize() {
		return size;
	}

	public void query(String q, String operator, Double magnitude, String location) {

		if(q.equals("magnitude")) {
			Earthquake sweep = tail;

			while(sweep != null) {
				switch(operator) {
					case ">" : if(magnitude < sweep.getMagnitude()) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
								}
								break;
					case "<" : if(magnitude > sweep.getMagnitude()) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
							    }
								break;
					default : System.out.println("Error, invalid operator");
					break;
				}
				sweep = sweep.getNext();
			}
		} else if(q.equals("depth")) {
			Earthquake sweep = tail;

			while(sweep != null) {
				switch(operator) {
					case ">" : if(magnitude < sweep.getDepth()) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
								}
								break;
					case "<" : if(magnitude > sweep.getDepth()) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
								}
								break;
					case "=" : if(magnitude == sweep.getDepth()) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
								}
								break;
					default : System.out.println("Error, invalid operator");
					break;
				}
				sweep = sweep.getNext();
			} 
		} else if(q.equals("date")) {
			Earthquake sweep = tail;

			while(sweep != null) {
				switch(operator) {
					case "=" : if(location.equals(sweep.getDate())) {
									System.out.printf(sweep.getLocation());
									System.out.printf(" " + sweep.getDate());
									System.out.printf(" " + sweep.getTime());
									System.out.printf(" Magnitude: " + sweep.getMagnitude());
									System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
								}
								break;
					default : System.out.println("Error, invalid operator");
					break;
				}
				sweep = sweep.getNext();
			} 
		} else if(q.equals("location")) {
			Earthquake sweep = tail;
			
			while(sweep != null) {
				if(location.equals(sweep.getLocation())) {
				    System.out.printf(sweep.getLocation());
        			System.out.printf(" " + sweep.getDate());
        			System.out.printf(" " + sweep.getTime());
        			System.out.printf(" Magnitude: " + sweep.getMagnitude());
        			System.out.printf(" Depth: " + sweep.getDepth() + " km \n");
				}
				sweep = sweep.getNext();
			}
		} 
	}
	
	public void displayList() {		
		printList = tail;
		
		while(printList != null) {
			
        	System.out.printf(printList.getLocation());
        	System.out.printf(" " + printList.getDate());
        	System.out.printf(" " + printList.getTime());
        	System.out.printf(" Magnitude: " + printList.getMagnitude());
        	System.out.printf(" Depth: " + printList.getDepth() + " km \n");
        	printList = printList.getNext();
   	 	}
	}
}


public class Test {
	public static EarthquakeLinkedList eList = new EarthquakeLinkedList();
	
	public static void readInput(String fileName) {
		try {
            File inputFile = new File(fileName);
            try (Scanner scanner = new Scanner(inputFile)) {
				while (scanner.hasNextLine()) {
				    String line = scanner.nextLine();

				    String[] str = line.split("\\s+");

				    String location = str[0];
				    String date = str[1];
				    String time = str[2];
				    double magnitude = Double.parseDouble(str[4]);
				    double depth = Double.parseDouble(str[6]);

					eList.addInput(location, date, time, magnitude, depth);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
		}
    }
        
	public static void readQueries(String fileName) {
		try {
			File inputFile = new File(fileName);
            try (Scanner scanner = new Scanner(inputFile)) {
				while (scanner.hasNextLine()) {
				    String line = scanner.nextLine();

				    String[] str = line.split("\\s+");

				    String query = str[0];
					if(query.equals("Query")) {
						String info = str[1];
						//String operator = parts[2];
						if(info.equals("location") || info.equals("date")) {
							String operator = str[2];
							String location = str[3];
							eList.query(info, operator, 0.0, location);
						} else if(info.equals("all")) {
							eList.displayList();
						} else {
							String operator = str[2];
							double magnitude = Double.parseDouble(str[3]);
							eList.query(info, operator, magnitude, "");
						}
						
					} else if(query.equals("Add")) {
						String location = str[1];
				    	String date = str[2];
				    	String time = str[3];
				    	double magnitude = Double.parseDouble(str[5]);
				    	double depth = Double.parseDouble(str[7]);

						eList.addQuerie(location, date, time, magnitude, depth);
						eList.displayList();
					} else if(query.equals("Delete")) {
						String location = str[1];
				    	String date = str[2];
				    	String time = str[3];
				    	double magnitude = Double.parseDouble(str[5]);
				    	double depth = Double.parseDouble(str[7]);

						eList.deleteQuerie(location, date, time, magnitude, depth);
						eList.displayList();
					} 
					System.out.println("-");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
		} 	
	}
	
	public static void main(String[] args) {
		readInput("input.txt");
		eList.displayList();
		System.out.println("-");
		readQueries("request.txt");	
	}
}
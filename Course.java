package lab7;

public class Course {

	private String name; 
	private int creditsEarned; 
	private int seatsRemaining; 
	private int enrolled;
	private Student[] roster; 
	
/** 
 * 
 * @param name name of course
 * @param creditsEarned by taking course
 * @param seatsAvailable in course 
 * 
 */
	public Course(String name, int creditsEarned, int seatsAvailable) {
		super();
		this.name = name;
		this.creditsEarned = creditsEarned;
		this.seatsRemaining = seatsAvailable;
		this.roster = new Student[seatsAvailable]; 
		this.enrolled = 0;
	} 
	

	/** 
	 * 
	 * @return getter for name 
	 */
	public String getName() {
		return this.name; 
	}
	/**
	 * 
	 * @return getter for credits 
	 */
	public int getCredits() {
		return this.creditsEarned; 
	}
	
	/**
	 * 
	 * @return getter for seatsRemaining
	 */
	public int getSeatsRemaining() {
		return this.seatsRemaining; 
	}
	/**
	 * 
	 * @return getter for enrolled
	 */
	public int getEnrolled() {
		return this.enrolled; 
	}
	/**
	 * 
	 * @return the sum of enrolled and seatsRemaining
	 */
	public int getCapacity() {
		return this.enrolled + this.seatsRemaining; 
	}

	
	/**
	 * 
	 * @param s - a student 
	 * @return true or false, if a student can be added to the course 
	 */
	public boolean addStudent(Student s) {
		if(this.seatsRemaining == 0) return false;
		for (int i=0; i<roster.length; i++) {
			if (roster[i] == s) {
				return false;
			}

			
			if (roster[i]== null) {
				roster[i] = s; 
				this.seatsRemaining -= 1;
				this.enrolled += 1;
				return true; 
			}
		}
		return true;
	}
	
		
/** 
 * 
 * @return a string of the array roster. 
 */
		public String generateRoster() {
			String rtString = null; 
			for (int i=0; i<roster.length; i++) {
				if (roster[i]==null) {
					rtString +="";
				}
				
				else {
					if (i >0 && roster[i-1]!= null) {
					rtString += roster[i].getFullName() + " "; 
					}
					else {
						rtString = roster[i].getFullName() + " "; 
					}
				}
				
			}
			System.out.println(rtString);
			return rtString; 
		}
		
		
		
		
		
		
		/** 
		 * 
		 * @return the calculation of average of the student's gpa
		 */
		public double calculateAverageGPA() {
			double gpa= 0; 
			int ppl = 0;
			for (int i=0; i<roster.length; i++) {
				if (roster[i] != null) {
				gpa += roster[i].calculateGradePointAverage(); 
				ppl+=1;
			}
			}
			
			gpa = (gpa/ppl); 
			return gpa; 
			
		}
		
		/**
		 * @return  a string of the student's name + their credits earned.
		 */
		public String toString() {
			return this.name + " " + this.creditsEarned; 
		}
		
		
		


	}


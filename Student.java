package lab7;

public class Student {

	private String firstName; 
	private String lastName; 
	private final int id;
	private int attemptedCredits; 
	private int passingCredits;
	private double gqpoints; 
	private double bbbalance;

	/**
	 * 
	 * @param firstName of student
	 * @param lastName of student 
	 * @param id - will not change
	 */
	public Student(String firstName, String lastName, final int id) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;

	}

	/**
	 * 
	 * @return String of firstName + lastName 
	 */
	public String getFullName() {
		return firstName + " " + lastName; 
	}

	/**
	 * @return getter for id
	 */
	public int getId() {
		return id; 
	}
	/**
	 * 
	 * @param grade  recieved
	 * @param credits earned
	 */
	public void submitGrade(double grade, int credits) {
		if (grade>=0.0 && grade <= 4.0) {
			if (grade>=1.7) {
				passingCredits += credits; 
			}
			attemptedCredits += credits; 			
			gqpoints += grade*credits; 
		}
		

	}

	/**
	 * 
	 * @return getter for attempted Credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits; 
	}

	/**
	 * 
	 * @return getter for total passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits; 
	}

	//should the two above call the submit grade method? 

	/**
	 * 
	 * @return gqpoints divided by attempted credits
	 */
	public double calculateGradePointAverage() {
		double gpa = (double)gqpoints/attemptedCredits; 
		return gpa; 

	}
	/**
	 * 
	 * @return the standing of the student, based on their passing credits.
	 */
	public String getClassStanding() {
		if (passingCredits<30) {
			return "FirstYear"; 
		}
		else if (passingCredits>=30 && passingCredits<60) {
			return "Sophomore"; 
		}
		else if (passingCredits>=60 && passingCredits<90) {
			return "Junior"; 
		}
		else {
			return "Senior"; 
		}
	}
	
	
	/**
	 * 
	 * @return true or false, if student is eligible for phi beta kappa based on their GPA and passing credits
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (this.calculateGradePointAverage()>=3.6 && this.getTotalPassingCredits()>=98) {
			return true;
		}
		else if (this.calculateGradePointAverage()>=3.8 && this.getTotalPassingCredits()>=75) {
			return true; 
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param amount of bear bucks deposited
	 */
	
	public void depositBearBucks(double amount) {
		this.bbbalance += amount; 
	}
	/**
	 * 
	 * @return  getter for bbbalance
	 */
	public double getBearBucksBalance() {
		return this.bbbalance;
	}
	
	/**
	 * 
	 * @param amount of bear bucks to deduct
	 */
	public void deductBearBucks(double amount) {
		this.bbbalance -= amount; 
	}
	
	/**
	 * 
	 * @return bear bucks account value, minus fees. 
	 */
	public double cashOutBearBucks() {
		if (this.bbbalance<=10.00) { 
			this.bbbalance =0;
			return 0; 
		}
		else {
			double b = this.bbbalance - 10; 
			this.bbbalance = 0; 
			return b; 
		}
	
		

	}
	
	/**
	 * 
	 * @param firstName first name of student
	 * @param otherParent - type student
	 * @param isHyphenated - boolean
	 * @param id - will not change
	 * @return a new student , with their last name and bear bucks balance based on the information of their two parents, this and otherParent
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, final int id) {

		String newLastName = ""; 
		
		if (isHyphenated ==true ) {
			newLastName = this.lastName + "-" + otherParent.lastName;
			
		}
		else {
			newLastName = this.lastName; 
		}
		
		Student child = new Student(firstName, newLastName, id); 
		
		
		double newbbbalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks(); 
		child.depositBearBucks(newbbbalance);
		System.out.println(newbbbalance);
		
		return child; 
				
	}
	
	
	
	/**
	 * @return a String containing the first name, last name and student id. 
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + ", Student id: " + this.id;
		
		
	}









}

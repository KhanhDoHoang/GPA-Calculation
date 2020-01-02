
import java.util.Scanner;

/*Made by Hoang Do
 * Sec 320 
 * Intro to Computer Programming
 * JASON MOMBOURQUETTE
 */




public class Student {
	 private long studNumber;
	 private String firstName;
	 private String lastName;
	 
	 private double[] marks;
	 
	 private double totalMarks;
	 private double totalBonus;
	 private double gpa;
	 
	 
	 private final int NUMBER_MARKS;
	 
	 private Scanner input;
	
	public Student()
	{
		this.NUMBER_MARKS = 3;
		this.marks = new double[NUMBER_MARKS];
		this.input = new Scanner(System.in);
	}
	
	public void readStudentDetails()
	{
		int numberOfBonus = -1;
		
		System.out.print("Enter student number: ");
		this.studNumber = input.nextLong();
	
		System.out.print("Enter first name: ");
		this.firstName = input.next();
		
		System.out.print("Enter last name: ");
		this.lastName = input.next();
		
		
		readMarks();
	
		//System.out.println("Enter number of Bonuses (should not be greater than 5)");
		//numberOfBonus = input.nextInt();
		
		do
		{
			
			System.out.print("Enter number of Bonuses (should not be greater than 5): ");
			numberOfBonus = this.input.nextInt();
			if(numberOfBonus > 5 || numberOfBonus < 0)
			{
				System.out.print("Number of bonuses should not be greater than 5!!!");
			}
			continue;
		}while(numberOfBonus > 5 || numberOfBonus < 0);
		readBonuses(numberOfBonus);
	}
	
	/*
	 *  need a do-while loop within a for 
		Page 2 of 6 loop. 
		If the entered value is not within the limit, print an error message and ask to re-enter until a
		valid value is entered
	 */
	private void readMarks()
	{
		for(int i = 0; i < marks.length; i++)
		{
			//System.out.println("Enter mark " + (i+1) + ":");
			//this.marks[i] = this.input.nextDouble();
			
			do
			{
				System.out.print("Enter mark " + (i+1) + ": ");
				this.marks[i] = this.input.nextDouble();		
				if(marks[i] < 0 || marks[i] > 100)
				{
					System.out.print("Math should be within 0 and 100. Please reenter");
				}
				continue;
			}while(marks[i] < 0 || marks[i] > 100);
			
			this.totalMarks += this.marks[i];
		}
		
		
	}
	
	private void readBonuses(int numberOfBonus)
	{
		for (int i = 1; i <= numberOfBonus; i++)
		{
			System.out.print("Enter bonus" + i + ": ");
			//int bonus = input.nextInt();
			//bonus
			this.totalBonus += input.nextDouble();
		}
	}
	
	/*method calculates the total marks of the student and calls convertBonus() method to
	get the total adjusted bonus. The method then adds totalBonus to totalMarks and finds the gpa using
	the formula:
	gpa = (totalMarks / (NUMBER_MARKS * 100)) * 4;
	If gpa is greater than 4, make it 4. If the student failed in any subject, gpa should be 0, regardless of
	the marks of other subjects. 
	 * 
	 */
	
	public double calculateGpa()
	{
		
		convertBonuses();
		
		this.totalMarks += this.totalBonus;
		this.gpa = (totalMarks / (NUMBER_MARKS * 100)) * 4;
		
		if(!this.checkEligibility())
		{
			this.gpa = 0;
		}
		if(this.gpa >= 4)
		{
			this.gpa = 4;
		}
		return this.gpa;
		
		//if gpa > 4 ---> ok
		//if student fails in any subject ---> gpa = 0
		
	}
	
	private double convertBonuses()
	{
		if(this.totalBonus > 15)
		{
			this.totalBonus = 15;
		}
		return (this.totalBonus/15) * 2;
	}
	
	private double calculatePercentage()
	{
		return (this.totalMarks / (this.NUMBER_MARKS * 100)) * 100;
	}
	
	public String findGradeLetter()
	{
		this.checkEligibility();
		while(this.checkEligibility())
		{
			if (this.calculatePercentage() >= 90) 
			{
				return "A+";
			}
			if (this.calculatePercentage() >= 85 && this.calculatePercentage() <= 89) 
			{
				return "A";
			}
			if (this.calculatePercentage() >= 80 && this.calculatePercentage() <= 84)
			{
				return "A-";
			}
			if (this.calculatePercentage() >= 77 & this.calculatePercentage() <= 79)
			{
				return "B+";
			}
			if (this.calculatePercentage() >= 73 & this.calculatePercentage() <= 76)
			{
				return "B";
			}
			if (this.calculatePercentage() >= 70 & this.calculatePercentage() <= 72)
			{
				return "B-";
			}
			if (this.calculatePercentage() >= 67 & this.calculatePercentage() <= 69)
			{
				return "C+";
			}
			if (this.calculatePercentage() >= 63 & this.calculatePercentage() <= 66)
			{
				return "C";
			}
			if (this.calculatePercentage() >= 60 & this.calculatePercentage() <= 62)
			{
				return "C-";
			}
			if (this.calculatePercentage() >= 57 & this.calculatePercentage() <= 59)
			{
				return "D+";
			}
			if (this.calculatePercentage() >= 53 & this.calculatePercentage() <= 56)
			{
				return "D";
			}
			if (this.calculatePercentage() >= 50 & this.calculatePercentage() <= 52)
			{
				return "D-";
			}
		}
		return "F";
			
	}
	
	private boolean checkEligibility()
	{
		//boolean val = true;
		
		for (int i = 0; i < this.NUMBER_MARKS; i++)
		{
			if(this.marks[i] < 50)
			{
				return false;
			}
			
		}
		return true;
	
	}
	
	/*method displays all information of the student (See output below). If the
	student failed in any of the subjects (hint: call checkeEligibility()), print a message, “NOTE: Failed
	in one or more courses”
	 */
	public void displayStudentDetails()
	{
			
			System.out.printf("%17d |%15s |%13.2f |%7.2f |%12s |", this.studNumber, this.firstName+" "+this.lastName, this.totalMarks, this.gpa , this.findGradeLetter());
			
			if(this.gpa == 0 )
			{
				System.out.print("    NOTE: Failed one or more courses");
			}
			
			System.out.println("");
			
			
	}
	
	/*for(int i = 0; i < marks.length; i++)
		{
			this.totalMarks += marks[i];
		}
	 * 
	 */
	public static void displayTitle()
	{
		System.out.println("************************************************************************************");
		System.out.println("				  MARK LIST              						 ");
		System.out.println("************************************************************************************");
	}
	
	public static void displayHeader()
	{
		System.out.println("  Student number  |       Name     | Total Marks  |  GPA   | Grade Letter|");
		System.out.println("--------------------------------------------------------------------------------");
		
	}
}


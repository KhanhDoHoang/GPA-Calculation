import java.util.Scanner;

public class StudentTest {
	public static void main (String[]args)
	{
		Scanner input = new Scanner(System.in); 
		System.out.println("GPA CALCULATOR \n=================");
		System.out.println("Enter number of student: ");
		
		int numStudents = input.nextInt();
		
		//how to put string in an array
		Student[] students = new Student[numStudents];
		
		//For each student, read details, cal gpa, find the grade letter
		for(int i = 0; i < numStudents; i++)
		{
			System.out.println("");
			System.out.println("Enter details of Student " + (i+1));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			students[i] = new Student();
			
			students[i].readStudentDetails();
			students[i].calculateGpa();
			students[i].findGradeLetter();
		}
		Student.displayTitle();
		//display the header of the result table
		Student.displayHeader();
		
		//display details of all students
		for (int i = 0; i < numStudents; i++)
		{
		
			students[i].displayStudentDetails();						
		}
		
		
		
		
	}
}

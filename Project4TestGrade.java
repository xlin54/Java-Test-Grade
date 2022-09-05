package allProject;
import java.util.Scanner;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Write a program to generate a grade report. 
 *
 * @author Xiao Yi Lin
 * @version 1.0
 */
public class Project4TestGrade{
	/**
	 * Creates programs to read process and display grade report for 4 students 
	 *
	 * @param args A reference to a string array containing command-line arguments
	 * @throws FileNotFoundException 
     */
	public static void main(String[] args) throws IOException {
//		1. Declare variables
//		2. Avoid magic numbers, so define menu items as constants
//		3. Create an array of 4 elements of type integer, name the array testOneScores
//		4. Makes an array of 4 elements of the type integer, name the array testTwoScores
//		5. Create an array of 4 elements of type double, name the array AverageArray
//		6. Create an array of 4 elements of type character, name the array letterGrades
		final int GRADE_REPORT = 1;
		final int GRADE_REPORT_IN_FILE = 2;
		final int EXIT = 3;
		int choice, count=1, countTwo=1;
		String fileName;
		PrintWriter outputFile;
	    DecimalFormat fmt1 = new DecimalFormat("000");
	    DecimalFormat fmt2 = new DecimalFormat("000.0"); 		
		Scanner scan = new Scanner(System.in);
		int[] testOneScores = new int[4];
		int[] testTwoScores = new int[4];
		double[] averageArray = new double[4];
		char[] letterGrades = new char[4];
		
//		7. Call the welcomeMessage method to output welcome text
//		8. Obtain a choice of 1,2, or 3, from user and assign it to the variable named choice
//		9. While the choice is not equal to 3 which is exit, the while loop keeps looping until 
//			the conditional is false, it stops when user enter in 3.
		welcomeMessage();
		choice = scan.nextInt();
		while(choice!=EXIT){
			
//			10. While the choice is 1 which is GRADE_REPORT, the code inside will loop
//			11. Print a message to say that this is test one
//			12. For integer index is equal zero, index is less than the length of testOneScores 
//			array which is 4, if condition is true, it will execute the for loop and the index 
//			will increment by 1 each time it loops, it loops only 4 times because index goes
//			from 1  to 3,count is used to label time test, test 1, test 2, test 3, test 4
			while(choice==GRADE_REPORT){
				System.out.println();
				System.out.println("Enter grades for test1 and test2 ");
				System.out.println("For test 1, ");
				for(int index = 0; index < testOneScores.length; index++){
					System.out.print("Enter score " +count+ ": ");
					count++;
					testOneScores[index]=scan.nextInt();

					}
				
//				13. For test 2 index starts from zero and increment to 3, obtain the first test
//				score and store it in index position 0 in testTwoScores array, obtain the second
//				test score and assign it in index position one in testTwoScores array, test 3 
//				score goes in index position 2, test 4 score goes in index position 3
				System.out.println();
				System.out.println("For test 2, ");
				for(int index = 0; index < testTwoScores.length; index++){
					System.out.print("Enter score " +(index+1)+ ": ");
					testTwoScores[index]=scan.nextInt();

					}

//				14. averageArray length is the number of elements inside of that array
//				15. Call the averageGpa method to calculate the average
//				16. For the first round it will get the elements at the index position 0 in 
//					testOneScore array and testTwoScore array, calculate the average and assign 
//					the letter grade to an element in index position 0 in averageArray
//				17. Then it gets the averageArray element at index position 0 pass it in a method
//					to calculate the letter grade and assign the letter grade to an element at
//					index position 0 of the letterGrades array
//				18. The first round is the elements of index position 0 of each array the second
//					round is the same process except is the element at index position 1 of each 
//					array  and then is the 3rd element of each array then the 4th elements of 
//					each array				
				for(int index = 0; index < averageArray.length; index++){
					averageArray[index]=averageGpa(testOneScores[index], testTwoScores[index]);
					letterGrades[index]=letterGpa(averageArray[index] );
					}				
				System.out.println();
				System.out.println();

//				19. Use\t to separate into columns like structure
//				20. Print all the elements inside each array in order and format them two
//					three digits
				System.out.println("Test 1\t" + "Test 2\t" + "Average\t" + "Grade\t" );
				System.out.println("------\t" + "------\t" + "------\t" + "------\t" );
				for(int index = 0; index < letterGrades.length; index++){
					System.out.println(fmt1.format( testOneScores[index])+"\t" + 
					fmt1.format(testTwoScores[index])+"\t" + fmt2.format(averageArray[index])+
					"\t" + letterGrades[index] );
					}
				System.out.println();
				System.out.println();
				
//				21. Call the welcome message method to display the prompt: enter one to display
//					report, two to write report to a file and 3 to quit
//				22. Use the scanner object to scan the next integer choice entered by the user
				welcomeMessage();
				choice = scan.nextInt();
			}
					
//			23. Use double equal sign for comparison
//			24. While the condition choice is equal to true: choice is equal to 2, then the
//				entire loop which execute as long as user keeps enter in 2.			
			while(choice==GRADE_REPORT_IN_FILE){
				System.out.println();
				System.out.println("Enter grades for test1 and test2 ");
				System.out.println("For test 1, ");
				
//				25. Get the user input test sore and store them in the testOneScores array
//					in order
				for(int index = 0; index < testOneScores.length; index++){
					System.out.print("Enter score " +countTwo+ ": ");
					countTwo++;
					testOneScores[index]=scan.nextInt();

					}
				System.out.println();
				System.out.println("For test 2, ");
				
//				26. Index changes from 0 to 3, so, index+1 is 1 to 4, used to count test 
				for(int index = 0; index < testTwoScores.length; index++){
					System.out.print("Enter score " +(index+1)+ ": ");
					testTwoScores[index]=scan.nextInt();

					}
				
//				27. Get the average of first element inside each test array and assign to the 
//					averageArray, make sure that the element in averageArray is the first 
//					element also, they must match
//				28. Call the letterGpa method to allocate letter grade.
//				29. Assign the letter grade in letterGrades array in order
				for(int index = 0; index < averageArray.length; index++){
					averageArray[index]=averageGpa(testOneScores[index], testTwoScores[index]);
					letterGrades[index]=letterGpa(averageArray[index] );
					}
				System.out.println("");
				
//				30. Print a message to let the user know that they should enter a file name
				System.out.println("A new file will be created for the report.");
				System.out.println("Enter a file name(For example, MyReport.txt): ");

//				31. Obtain user input and assign it in a string variable called fileName
//				32. Pass the fileName to PrintWriter, a PrintWriter creates a file and output 
//				    text to the file
//				33. Use PrintWriter object to print report to the file by passing in the 
//					arguments in the println method, to see the file, after the program 
//					terminates, that is after user enter 3, right click on the project folder
//					and click refresh
				fileName=scan.next();
				outputFile= new PrintWriter(fileName);
				outputFile.println("Test 1\t" + "Test 2\t" + "Average\t" + "Grade\t" );
				outputFile.println("------\t" + "------\t" + "------\t" + "------\t");
				
//				34. Use decimal format object to format the average to at least one decimal
//				places and three leading zeros
//				35. To print the elements inside the array, enter the array named followed 
//				by the brackets, and pass in the index position in brackets
				outputFile.println(fmt1.format(testOneScores[0])+"\t\t" + 
				fmt1.format(testTwoScores[0])+"\t\t" + fmt2.format(averageArray[0])
				+"\t\t" + letterGrades[0]);
				outputFile.println(fmt1.format(testOneScores[1])+"\t\t" +
				fmt1.format(testTwoScores[1])+"\t\t" + fmt2.format(averageArray[1])
				+"\t\t" + letterGrades[1]);
				outputFile.println(fmt1.format(testOneScores[2])+"\t\t" +
				fmt1.format(testTwoScores[2])+"\t\t" + fmt2.format(averageArray[2])
				+"\t\t" + letterGrades[2]);
				outputFile.println(fmt1.format(testOneScores[3])+"\t\t" + 
				fmt1.format(testTwoScores[3])+"\t\t" + fmt2.format(averageArray[3])
				+"\t\t" + letterGrades[3]);
				System.out.println("Report written into a file: " + fileName);
				System.out.println("");
				System.out.println("");
				
//				36. Call the welcome message again
//				37. Store the user input of choice in the choice variable
//				38. Close the PrinterWriter object
//				39. Close the scanner
				welcomeMessage();
				choice = scan.nextInt();
				outputFile.close();
			}
		}
		scan.close();
	}

//	40. Create a static method and give the method an descriptive name, specify the type double
//	41. It takes in two integer parameters
//	42. Add the two parameters and divide by 2, cast to double
//	43. return the result	
	public static double averageGpa(int testOne, int testTwo){
	      double result; 
	      result = (double)(testOne + testTwo)/2;
	      return result;	
	}

//	44. Create a character type method that takes in a parameter which is a double type object
//	45. Declare letter as a character type variable
//	46. If the object is greater than or equal to 90, assign A to the letter variable
//	47. else if the object is greater than or equal to 90, assign A to the letter variable
//	48. else if the object is greater than or equal to 90, assign A to the letter variable
//	49. else assign A to the letter variable
//	50. return the value in letter variable 
	public static char letterGpa(double gpa ) { 
		char letter;
		if(gpa >=90) {
			letter = 'A';
		}else if(gpa >=80) {
			letter = 'B';
		}else if(gpa >=70) {
			letter = 'C';
		}else  {
			letter = 'F';
		} 
		return letter;
	}

//	51. Within the class body, create another method to display the welcome message,
//	so that, by writing the name of the method followed by parentheses and colon
//	we can call the method and execute the code inside
	public static void welcomeMessage(){
		System.out.println("Welcome to Grade Center! " );
		System.out.println("Enter 1 to generate and display a grade report. " );
		System.out.println("Enter 2 to generate a grade report and save it into a file. " );
		System.out.println("Enter 3 to quit. " );
		System.out.print("Enter a choice: " );
	 }	
}
	







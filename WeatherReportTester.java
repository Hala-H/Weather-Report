// CS 120 Spring 2019 
// Mid term Project
// Weather Report Tester class to test classes and methods

package CS120P1;
import java.util.Scanner ; // program uses class Scanner

public class WeatherReportTester {

	// main method begins execution of java application
	public static void main (String args []) {
		int num = 1 ; // declare num as type integer

		// create scanner to input from command window
		Scanner input = new Scanner (System.in) ;
		System.out.println("Welcome to our Weather Report Station") ;
		do {
			// Menu to display options
			System.out.println("-----------------------------------------------------") ;
			System.out.println("1. Test the TimeStamp class") ;
			System.out.println("2. Compare two Temperatures") ;
			System.out.println("3. Test the WeatherReport class") ;
			System.out.println("4. Exit") ;
			System.out.println("-----------------------------------------------------") ;
			System.out.println() ;

			// prompt user to enter the action they want to perform
			System.out.print("Choose the number of the action you want : ") ; 
			num = input.nextInt() ; // reads user input and assigns it to num
			System.out.println() ;	

			while (num <=0 || num>=5) { // if the user entered a number out of range

				System.out.println("Out of range !"); 
				System.out.print("Please enter a number between 1 and 4:") ; // prompt user to re enter
				num = input.nextInt() ; // re reads user input and assigns it to num
				System.out.println() ;
				
			} // end while loop

			switch (num) {  // switch between num values
			case 1 : // when user enters 1
				while(num==1) {
					TimeStamp timestamp = new TimeStamp (0 , 0 , 0) ; // creates object timestamp
					System.out.println("************************") ;
					System.out.println("Test the TimeStamp class") ;
					System.out.println("************************") ;

					System.out.print("Enter Day:") ; // prompt user to enter day
					int day = input.nextInt() ; // reads and declares user input and assigns it to day
					timestamp.setDay(day) ; // call method setDay 

					System.out.print("Enter Hour:") ; // prompt user to enter hour
					int hour = input.nextInt() ; // reads and declares user input and assigns it to hour
					timestamp.setHour(hour) ; // call method setHour 

					System.out.print("Enter Minute:") ; // prompt user to enter minute
					int minute = input.nextInt() ; // reads and declares user input and assigns it to minute
					timestamp.setMinute(minute) ; // call method setMinute 

					System.out.println();
					System.out.println("Timestamp "  + timestamp.toString()) ; // display timestamp
					System.out.println() ;
					num++ ;

				}  // end first while loop	
				break ;

			case 2 : // when user enters 2
				while (num == 2) {

					System.out.println("************************") ;
					System.out.println("Compare two Temperatures") ;
					System.out.println("************************") ;
					System.out.println("Guidelines :") ;
					System.out.println("You will get  0 if both temperatures are equal(or almost equal).") ;
					System.out.println("You will get -1 if the first temperature is less than the second.") ;
					System.out.println("You will get  1 if the first temperature is greater than the second.") ;
					System.out.println("**********************************************************************") ;

					Temperature t1 = new Temperature (0.0) ; // creates object t1 
					Temperature t2 = new Temperature (0.0) ; // creates object t1 

					System.out.print("Enter First Temperature: ") ; // prompt user to enter first temperature
					double temp1 = input.nextDouble() ; // reads and declares user input and assigns it to temp1
					System.out.print("Enter First Scale: ") ; // prompt user to enter scale
					String scale1 = input.next() ; // reads and declares user input and assigns it to scale1

					t1.setTemp(temp1, scale1) ; // calls method setTemp

					System.out.print("Enter Second Temperature: ") ; // prompt user to enter second temperature
					double temp2 = input.nextDouble() ; // reads and declares user input and assigns it to temp2
					System.out.print("Enter Second Scale: ") ; // prompt user to enter scale
					String scale2 = input.next() ; // reads and declares user input and assigns it to scale2

					t2.setTemp(temp2, scale2) ; // calls method setTemp

					System.out.println();
					System.out.println("Comparison: " + Compare.compare(t1, t2)) ; // display comparison
					System.out.println();
					num++ ;
				}  // end second while loop
				break ;

			case 3 : // when user inputs 3
				while (num == 3){

					System.out.println("****************************") ;
					System.out.println("Test the WeatherReport class") ;
					System.out.println("****************************") ;	

					TimeStamp ts = new TimeStamp (0 , 0 , 0) ; // creates object ts

					System.out.print("Enter Day:") ; // prompt user to enter day
					int day = input.nextInt() ; // reads and declares user input and assigns it to day
					ts.setDay(day);	// calls method setDay

					System.out.print("Enter Hour:") ; // prompt user to enter hour
					int hour = input.nextInt() ; // reads and declares user input and assigns it to hour
					ts.setHour(hour); // calls method setHour

					System.out.print("Enter Minute:") ; // prompt user to enter minute
					int minute = input.nextInt() ; // reads and declares user input and assigns it to minute
					ts.setMinute(minute);	// calls method setMinute

					Temperature t = new Temperature(0.0) ; // creates object t

					System.out.print("Enter Temperature: ") ; // prompts user to enter temperature
					double temp = input.nextDouble() ; // reads and declares user input and assigns it to temp
					t.setTemp(temp) ; // calls method setTemp

					System.out.print("Enter Scale: ") ; // prompts user to enter scale
					String scale = input.next(); // reads and declares user input and assigns it to scale
					t.setTemp(temp,scale) ; // calls method setTemp

					WeatherReport report = new WeatherReport(t , ts) ; // creates object report

					System.out.println();
					System.out.println("Weather Report :" + report.toString()) ; // displays report
					System.out.println();
					num ++ ;
				}  // end third while loop
				break ;

			case 4 : // when user enters 4
				while(num == 4) { // exits application
					System.out.println("Thank you for using our Weather Report Station !") ;
					num ++ ;
				} // end fourth while loop
				break ;

			} // end switch	

		} while ( num > 0 && num < 5 ); // within range
		input.close();
	} // end main
} // end class


// Name: Cooper MacDonald
// Date: September 14, 2023
// App name: Calculator
// App Description: Calculator that does simple arithmetic calculations.

import java.util.Scanner;

public class Calculator 
{
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final String BANNER_INSTRUCTIONS = "Calculator";
    static final String OUTPUT_BANNER = "Calculator";
        
    public static void main(String[] args) 
    {
        // Variables 
        float firstNumber = 0;
        float secondNumber = 0;
        float result = 0;
        char operator = ' '; // ( + - * / ) - char means only 1 letter/character
        boolean valid = false; // Used for validation
        
        // User input
        Scanner scanner = new Scanner(System.in);

        // Set the terminal title
        System.out.printf(SET_TITLE, "Calculator - Cooper MacDonald");

        // Print the Banner and Instructions 
        // Ask for a calculation 
        System.out.print(BANNER_INSTRUCTIONS + "Enter calculation: ");

        // Try to get a number operator number 
        try 
        {
            // 1 + 2/n
            // + 2/n
            // 2/n
            // /n
            firstNumber = scanner.nextFloat();
            operator = scanner.next().charAt(0); // Just the first index
            secondNumber = scanner.nextFloat();
            // Input was good!
            valid =  true; 
        }
        catch(Exception exception)
        {
            // Input was not good!
            valid = false; 
        }

        // Get rid of the leftover input
        scanner.nextLine();

        // Error in case the input is not valid 
        if(!valid)
        {
            System.out.println("Error - Invalid number!");
        }

        // Calculation (We have valid entry)
        else 
        {
            // Decide which operation to do
            switch(operator)
            {
                // In case user chooses addition 
                case '+':
                    result = firstNumber + secondNumber;
                    break; // Stop here, otherwise falls through next case 
                // In case user chooses subtraction 
                case '-':
                    result = firstNumber - secondNumber;
                    break; // Stop here, otherwise falls through next case 
                // In case user chooses multiplication 
                case '*':
                    result = firstNumber * secondNumber;
                    break; // Stop here, otherwise falls through next case 
                // In case user chooses division 
                case '/':
                    if(secondNumber == 0)
                    {
                        System.out.println("Error - Cannot divide by 0!");
                        valid = false; // invalidate the input
                    }
                    else
                    {
                    result = firstNumber / secondNumber;
                    }
                    break; // Stop here, otherwise falls through next case 
                
                default: // Same as an else 
                    System.out.println("Error - Invalid operator!");
                    valid = false; // invalidate the input
            }
        }
        
        // Only print the result in case the operation is valid!
        if (valid)
        {
            // Clear the terminal and display the output banner 
            System.out.println(CLEAR_TERMINAL + OUTPUT_BANNER);

            // Display the result 
            // %f means float, %s is string
            // %.1f should have one decimal place
            // Technically you can use %s for all of them, so they are converted to strings and cut off at one decimal place
            System.out.printf("%s %s %s = %s\n", firstNumber, operator, secondNumber, result);
        }

        // Exit prompt 
        System.out.print("Press [enter] to exit: ");
        scanner.nextLine();
        scanner.close(); // Close communication with the terminal
        
    }
    
}

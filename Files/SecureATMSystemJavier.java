/**
 * * @author Javier
 * @version 1.0
 */
import java.util.Scanner;
public class SecureATMSystemJavier { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //initializations 
        String correctPin = "Javier1234";
        boolean isPinCorrect = false;
        int attempts = 0;
        double anda = 28500; //erap ko

        //logic for entering pin (3 attempts)
        while (attempts < 3 && !isPinCorrect) {
            System.out.print("Please enter your pin: ");
            String enteredPin = scanner.nextLine();

            //logic for pin checking if match sa real pin
            if (enteredPin.equals(correctPin)) { 
                isPinCorrect = true;
            } else {
                attempts++;
                System.out.println("Warning: Incorrect PIN.");
                
                if (attempts < 3) {
                    System.out.println("You have " + (3 - attempts) + " attempt(s) remaining.\n");
                }
            }
        }
        
        //if magexceed attempts sa 3 na mali, lock account
        if (attempts == 3 && !isPinCorrect) {
            System.out.println("Account Locked");
        }

        //if tama yung pin, disp menu and let user choose
        if (isPinCorrect == true) {
            int choice;
            
            do {
                System.out.println("\n===== ATM MENU ====="); 
                System.out.println("1. Check Balance"); 
                System.out.println("2. Deposit"); 
                System.out.println("3. Withdraw"); 
                System.out.println("4. Exit");
                System.out.print("Choose: ");
                choice = scanner.nextInt();
                
                //switch case for choices
                switch (choice) {
                    case 1:
                        System.out.println("Here is your current balance: " + anda);
                        break;
                    case 2:
                        double deposit;
                        // prevent negative or zero deposits
                        do {
                            System.out.print("Enter the desired deposit amount: ");
                            deposit = scanner.nextDouble();
                            
                            if (deposit <= 0) {
                                System.out.println("Invalid amount. Please enter positive integers only.");
                            }
                        } while (deposit <= 0);
                        //process
                        anda += deposit;
                        System.out.println("Deposit successful! You have added " + deposit + " pesos to your account.");
                        break;
                    case 3:
                        double withdraw;
                        //prevent negative or zero withdrawals
                        do {
                            System.out.print("Enter the desired withdrawal amount: ");
                            withdraw = scanner.nextDouble();
                            
                            if (withdraw <= 0) {
                                System.out.println("Invalid amount. Please enter positive integers only.");
                            }
                        } while (withdraw <= 0);
                        //validation and process
                        if (withdraw <= 2000) { 
                            if (withdraw <= anda) {
                                anda -= withdraw;
                                System.out.println("Withdrawal successful! You have taken " + withdraw + " pesos from your account.");
                            } else {
                                System.out.println("Sorry! Insufficient balance. Try to deposit more to withdraw your desired amount.");
                            }
                        } else {
                            System.out.println("Warning: The maximum withdrawal per transaction is 2,000 pesos.");
                        }
                        break;
                    case 4:
                        System.out.println("Now Exiting ATM...");
                        break;
                    default:
                        System.out.println("Invalid Option, please choose from 1-4 only.");
                        break;
                }
            } while (choice != 4);
        }
        scanner.close();
    }
}
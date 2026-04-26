/**
 * * @author Javier
 * @version 1.0
 */
import java.util.Scanner;

public class StudentPaymentSystemJavier{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Ask user to input details
        System.out.print("Please enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter student ID: ");
        String id = scanner.nextLine();
        double bill;
        do {
            System.out.print("Please enter total tuition fee: ");
            bill = scanner.nextDouble();
            if (bill < 0) {
                System.out.println("Invalid input. Tuition fee cannot be negative.");
            }
        } while (bill < 0);

        //initialization
        int choice;
        int transactions = 0; 
        boolean mayDiscountBa = false;

        //display menu
        do {
            System.out.println("\n===== PAYMENT MENU ====="); 
            System.out.println("1. Pay Tuition"); 
            System.out.println("2. Check Balance"); 
            System.out.println("3. Apply Discount"); 
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: //pay tuition 
                    if (bill <= 0) {
                        System.out.println("No remaining balance.");
                    } else {
                        double payment;
                        //prevent negative payments
                        do {
                            System.out.print("Enter payment amount: ");
                            payment = scanner.nextDouble();
                            
                            if (payment < 0) {
                                System.out.println("Invalid input. Payment cannot be negative.");
                            }
                        } while (payment < 0);

                        //validation
                        if (payment > bill) {
                            System.out.println("Invalid Payment");
                        } else {
                            bill -= payment;
                            transactions++; //transaction counter
                            System.out.println("Payment successful! Your balance is now " + bill + " pesos.");
                        }
                    }
                    break;
                case 2: //check balance
                    System.out.println("Remaining Balance: " + bill); 
                    transactions++;
                    break;
                case 3: //apply discount
                    if (!mayDiscountBa) { //multiple discount prevention
                        System.out.println("Are you a:");
                        System.out.println("1. Regular Student"); 
                        System.out.println("2. Scholar"); 
                        System.out.print("Enter choice: ");
                        int type = scanner.nextInt();

                        if (type == 2) {
                            double discount = bill * 0.20; 
                            bill -= discount; 
                            System.out.println("20% discount applied.");
                            mayDiscountBa = true;
                        } else if (type == 1) {
                            System.out.println("No discount for Regular Students."); 
                            mayDiscountBa = true;
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Discount has already been applied.");
                    }
                    break;
                case 4:

                    System.out.println("\n--- Result ---");
                    System.out.println("Student Name: " + name);
                    System.out.println("Total Transactions: " + transactions);
                    System.out.println("Final Balance: " + bill);
                    break;
                default:
                    System.out.println("Invalid menu option.");
                    break;
            }
        } while (choice != 4); //until exit niya

        scanner.close();
    }
}
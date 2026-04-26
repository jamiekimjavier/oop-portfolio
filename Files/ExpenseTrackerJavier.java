import java.util.Scanner;

/**
 * @author Javier
 * @version 1.0
 */
public class ExpenseTrackerJavier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayProgramTitle();
        
        //accept user input (enhancement 1/4)
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        //display a personalized message (enhancement 2/4)
        System.out.print("Good day, " + userName + " !\n");
        System.out.print("Please input your overall budget: ");
        double budget = scanner.nextDouble();

        System.out.print("Please input the total of your food expenses: ");
        double puds = scanner.nextDouble();

        System.out.print("Please input the total of your transportation expenses: ");
        double transpo = scanner.nextDouble();

        System.out.print("Input other general expenses: ");
        double other = scanner.nextDouble();

        //add another expense category (enhancement 3/4)
        double customExpensesCatTotal = 0.0;
        System.out.print("\nWould you like to add a custom expense category? (Y/N): ");
        String choice = scanner.next();
        
        while (choice.toUpperCase().equals("Y")) {
            scanner.nextLine(); 
            
            System.out.print("Enter the name of this custom category: ");
            String categoryName = scanner.nextLine();
            
            System.out.print("Enter the expense amount for " + categoryName + ": ");
            double amount = scanner.nextDouble();
            
            customExpensesCatTotal = customExpensesCatTotal + amount; 
            
            System.out.print("\nWould you like to add another custom expense category? (Y/N): ");
            choice = scanner.next();
        }
        System.out.println("Successfully added custom categories!\n");
        
        //calling my methods
        double baseExpenses = calculateTotalExpenses(puds, transpo, other);
        double grandTotal = baseExpenses + customExpensesCatTotal;
        String statusMessage = checkBudgetStatus(grandTotal, budget, userName);
        
        //displaying final output
        displayTotalExpenseAndBudget(userName, grandTotal, budget, statusMessage);

        scanner.close();
    }

//void method that displays the program title
    public static void displayProgramTitle() {
        System.out.println("==========PERSONAL EXPENSE TRACKER==========");
    }

//non-void method that calculates the tot expenses using 3 values
    public static double calculateTotalExpenses(double puds, double transpo, double other) {
        return puds + transpo + other;
    }

//non-void method that checks if the total expencess exceeds a budget and returns a message
    public static String checkBudgetStatus(double totalExpense, double budget, String userName) {
        if (totalExpense > budget) {
            //display a personalized message (enhancement 2/4)
            return "Budget exceeded! Please proceed to cut back on your expenses," + userName;
        } else if (totalExpense == budget) {
            return "WARNING: You have spent your exact allocated budget, please avoid spending more as much as possible.";
        } else {
            return "You right are within your budget. Good job, " + userName;
        }
    }

//void method that displays tot expense and budget status
    public static void displayTotalExpenseAndBudget(String name, double totalExpense, double budget, String statusMsg) {
        //compute remaining budget (enhancement 4/4) yeyy
        double remaining = budget - totalExpense; 
        
        //display a personalized message (enhancement 2/4)
        System.out.println("========" + name + "'s Financial Summary========");
        System.out.println("Total Budget     : " + budget + " Pesos");
        System.out.println("Total Expenses   : " + totalExpense + " Pesos");
        System.out.println("Remaining Balance: " + remaining + " Pesos");
        System.out.println("====================================================");
        System.out.println("Status: " + statusMsg);
        System.out.println("====================================================");
    }
}
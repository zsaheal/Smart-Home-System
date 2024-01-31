import java.util.Scanner;

public class Spending {
    private int runningTotalSpent = 0;
    private int budgetMonth = 0;
    private int toAddToBudgetNewInc = 0;
    private int toRemoveBudget = 0;

    public Spending() {
        budgetMonth = enterBudget();
        toAddToBudgetNewInc = logIncome();
        budgetMonth = budgetMonth + toAddToBudgetNewInc;
        toRemoveBudget = logSpend();
        budgetMonth = budgetMonth - toRemoveBudget;
        System.out.println("current budget: " + budgetMonth);
    }

    public int logSpend() {
        System.out.println("would you like to log reduced budget for heating? ");
        Scanner scannerr = new Scanner(System.in);
        String response = scannerr.nextLine();
        if (response == "yes") {
            System.out.println("how much would you like to remove? ");
            Scanner scanner3 = new Scanner(System.in);
            String response3 = scanner3.nextLine();
            int removedB = Integer.valueOf(response3);
            return removedB;
        } else {
            System.out.println("budget will not be reduced. ");
            return 0;
        }
    }

    public int enterBudget() {
        System.out.println("what is your monthly budget for heating? ");
        Scanner scanner = new Scanner(System.in);
        String enteredBudget = scanner.nextLine();
        try {
            budgetMonth = Integer.valueOf(enteredBudget);
        } catch (Exception e) {
            System.out.println("please enter a valid (integer ");
        }
        return budgetMonth;
    }

    public int logIncome() {
        System.out.println("would you like to log additional income you've made to add to gas budget?(yes/no) ");
        Scanner scanner1 = new Scanner(System.in);
        String response = scanner1.nextLine();
        if (response == "yes") {
            System.out.println("how much would you like to add? (whole number)");
            Scanner scanner2 = new Scanner(System.in);
            String response2 = scanner2.nextLine();
            int additionalB = Integer.valueOf(response2);
            // budgetMonth = budgetMonth + additionalB;
            return additionalB;
        } else {
            System.out.println("ok we will not add additional budget to heating for the month");
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        Spending sp = new Spending();
    }
}
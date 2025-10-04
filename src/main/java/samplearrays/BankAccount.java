package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    // Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int transactionsCounter = 0;

    public BankAccount(String name, int startingBalance){
        this.name =  name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount<0){
            System.out.println("Unsuccessful deposit : Invalid amount");
        }
        else{
            transactions[transactionsCounter] = amount;
            currentBalance += amount;
            transactionsCounter++;
            System.out.println("-------------------------------" +
                    "\nDepositor : "+name +
                    "\nDeposited Amount : "+amount +
                    "\nNew balance : "+ currentBalance +
                    "\n-------------------------------");
        }

    }

    public void withdraw(double amount){
        if (amount < 0 || amount > currentBalance){
            System.out.println("Unsuccessful withdraw : Invalid amount");
        }
        else{
            currentBalance -= amount;
            transactions[transactionsCounter] = -1 * amount;
            transactionsCounter++;
        }
    }

    public void displayTransactions(){
        System.out.println("All transactions : ");
        for ( double transaction : transactions){
            if (transaction > 0) {
                System.out.println("Deposit : " + transaction);
            }
            else {
                System.out.println("Withdraw : " + transaction);
            }

        }
    }

    public void displayBalance(){
        System.out.println("Balance : " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

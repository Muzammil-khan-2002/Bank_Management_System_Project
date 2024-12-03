import java.util.Scanner;

class Account {
    private String account_no;
    private String holder_name;
    private double balance;

    // Setter methods
    public void setAccount_No(String account_no) {
        this.account_no = account_no;
    }

    public void setHolderName(String holder_name) {
        this.holder_name = holder_name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter methods
    public String getAccount_No() {
        return account_no;
    }

    public String getHolderName() {
        return holder_name;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }

    // Display account information
    public void displayAccountInfo() {
		System.out.println("\n_____________________________________________________________");
        System.out.println("\nAccount No: \t" + account_no);
        System.out.println("Holder Name: \t" + holder_name);
        System.out.println("Balance: \t" + balance);
    }
}

class Bank {
    private Account[] accounts = new Account[100]; // Array to store accounts
    private int count = 0; // To keep track of the number of accounts

    // Add new account
    public void addAccount(Account account) {
        accounts[count] = account;
        count++;
        System.out.println("Account added successfully!");
    }

    // Remove account by account number
    public void removeAccount(String account_no) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccount_No().equals(account_no)) {
                for (int j = i; j < count - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[count - 1] = null;
                count--;
                System.out.println("Account removed successfully!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    // Find account by account number
    public Account findAccount(String account_no) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccount_No().equals(account_no)) {
                return accounts[i];
            }
        }
        return null;
    }

    // Display total balance of all accounts
    public void totalBalance() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        System.out.println("Total balance in the bank: " + total);
    }

    // Display all accounts' information
    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
        }
    }
}

public class BankApplication {
    public static void main(String[] args) {
        Scanner xyz = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;
        int subChoice;

        do {
            // Ask for permission each time
            System.out.println("Are you the Bank owner or Account holder?");
            String permission = xyz.nextLine();

            System.out.println("1-Proceed");
            System.out.println("0-Terminate Code");
            choice = xyz.nextInt();

            if (permission.equalsIgnoreCase("owner")) {
                do {
                    System.out.println("1-Add new Account");
                    System.out.println("2-Find Account");
                    System.out.println("3-Remove Account");
                    System.out.println("4-Total Balance");
                    System.out.println("5-Display All Accounts");
                    System.out.println("0-Terminate");
                    System.out.println("Enter Your Choice");
                    subChoice = xyz.nextInt();

                    switch (subChoice) {
                        case 1: {
                            Account account = new Account();
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number: ");
                            account.setAccount_No(xyz.nextLine());
                            System.out.println("Enter Holder Name: ");
                            account.setHolderName(xyz.nextLine());
                            System.out.println("Enter Initial Balance: ");
                            account.setBalance(xyz.nextDouble());
                            bank.addAccount(account);
                        }
                        break;
                        case 2: {
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number: ");
                            String accNo = xyz.nextLine();
                            Account account = bank.findAccount(accNo);
                            if (account != null) {
                                account.displayAccountInfo();
                            } else {
                                System.out.println("Account not found!");
                            }
                        }
                        break;
                        case 3: {
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number to Remove: ");
                            String accNo = xyz.nextLine();
                            bank.removeAccount(accNo);
                        }
                        break;
                        case 4: {
                            bank.totalBalance();
                        }
                        break;
                        case 5: {
                            bank.displayAllAccounts();
                        }
                        break;
                        case 0:
                            System.out.println("Owner, Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } while (subChoice != 0);
            }
			else if (permission.equalsIgnoreCase("holder")) {
                do {
                    System.out.println("1-Deposit");
                    System.out.println("2-Withdraw");
                    System.out.println("3-Display Account Info");
                    System.out.println("0-Terminate");
                    System.out.println("Enter Your Choice");
                    subChoice = xyz.nextInt();

                    switch (subChoice) {
                        case 1: {
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number: ");
                            String accNo = xyz.nextLine();
                            Account account = bank.findAccount(accNo);
                            if (account != null) {
                                System.out.println("Enter Deposit Amount: ");
                                double amount = xyz.nextDouble();
                                account.deposit(amount);
                            } else {
                                System.out.println("Account not found!");
                            }
                        }
                        break;
                        case 2: {
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number: ");
                            String accNo = xyz.nextLine();
                            Account account = bank.findAccount(accNo);
                            if (account != null) {
                                System.out.println("Enter Withdraw Amount: ");
                                double amount = xyz.nextDouble();
                                account.withdraw(amount);
                            } else {
                                System.out.println("Account not found!");
                            }
                        }
                        break;
                        case 3: {
                            xyz.nextLine(); // Consume newline
                            System.out.println("Enter Account Number: ");
                            String accNo = xyz.nextLine();
                            Account account = bank.findAccount(accNo);
                            if (account != null) {
                                account.displayAccountInfo();
                            } else {
                                System.out.println("Account not found!");
                            }
                        }
                        break;
                        case 0:
                            System.out.println("Holder, Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } while (subChoice != 0);
            }
			else{
				System.out.println("Invalid Input,");
			}
            // Ask for permission again after session ends
            xyz.nextLine(); // Consume newline

        } while (choice != 0);
        xyz.close();
    }
}

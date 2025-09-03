import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankOperations {

    List<AccountDetails> accountList = new ArrayList<>();
    String nm;
    long accNo;
    double initialBal;
    int pin;

    public int mainMenu(Scanner sc) {
        System.out.println("\n----- Bank Account Manager -----");
        System.out.println("---------------------------------");
        System.out.println("1. Add Account");
        System.out.println("2. View Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Check Balance");
        System.out.println("6. Transfer Money");
        System.out.println("7. Delete Account");
        System.out.println("8. Exit");

        System.out.print("Enter your Choice: ");
        return sc.nextInt();
    }

    public void addAccount(Scanner sc) {
        sc.nextLine();
        do {
            accNo = (long) (Math.random() * 90000000) + 10000000;
            System.out.println(String.valueOf(accNo).length());
        } while (String.valueOf(accNo).length() > 8);
        System.out.println("|| Account Number: " + accNo + " ||");
        System.out.print("Enter your Name: ");
        nm = sc.nextLine();
        System.out.print("Enter Your Initial Balance: ");
        initialBal = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter your pin: ");
        getPin(sc);
        accountList.add(new AccountDetails(accNo, nm, pin, initialBal));
        System.out.println("Account Created Successfully!!!");
    }

    public void viewAccounts() {
        if (accountList.isEmpty()) {
            System.out.println(" ❌ No Record Found !!!");
        } else {
            tableView();
            for (AccountDetails a : accountList) {
                System.out.print(a);
            }
        }
    }

    public void depositMoney(Scanner sc, long accNo) {
        AccountDetails ad = findAccByNo(accNo);
            if (ad != null) {
                System.out.print("Enter Money to Deposit: ");
                double depositAmt = sc.nextDouble();
                ad.setInitialBal(ad.getInitialBal() + depositAmt);
                System.out.println("Your Money is Deposited..");
                System.out.println("--> Updated Bank Balance: " + ad.getInitialBal());
            } else {
                System.out.println("Account Not Found...");
            }
    }

    public void withdrawMoney(Scanner sc, long accNo) {
        AccountDetails ad = findAccByNo(accNo);
        if (ad != null) {
            System.out.print("Enter Money to Withdraw: ");
            double depositAmt = sc.nextDouble();
            if (depositAmt > ad.getInitialBal()) {
                System.out.println("Insufficient Balance...");
            } else {
                ad.setInitialBal(ad.getInitialBal() - depositAmt);
                System.out.println("Your Money is withdrawn..");
                System.out.println("--> Remaining Bank Balance: " + ad.getInitialBal());
            }
        } else {
            System.out.println("Account Not Found...");
        }
    }

    public void checkBalance(long accNo) {
        AccountDetails ad = findAccByNo(accNo);
        if (ad != null) {
            System.out.println("Your Account Balance is: " + ad.getInitialBal());
        } else {
            System.out.println("Account Not Found...");
        }
    }

    public void deleteAccount(long accNo, Scanner sc) {
        AccountDetails ad = findAccByNo(accNo);
            sc.nextLine();
        if (ad != null) {
            System.out.print("--> Are you sure (y/n): ");
            String c = sc.nextLine();
            if (c.equals("y")) {
                accountList.remove(ad);
                System.out.println("Account Deleted Successfully!!");
            } else {
                System.out.println("Great choice...");
            }
        } else {
            System.out.println("Account Not Found...");
        }
    }

    //    Optional
    //    public void transferMoney() {
    //    }

    public void getPin(Scanner sc) {
        boolean flag = true;

        while (flag) {
            pin = sc.nextInt();
            if (String.valueOf(pin).length() >= 4) {
                System.out.println("pin is set..");
                flag = false;
            } else {
                System.out.print("pin must be greater than 4 numbers. " +
                        "\n--> Enter pin Again: ");
            }
        }
    }

    public AccountDetails findAccByNo(long accNo) {
        for (AccountDetails a : accountList) {
            if (a.getAccNo() == accNo) {
                return a;
            }
        }
        return null;
    }

    public void tableView() {
        System.out.printf("%-18s %-20s %-15s%n", "Account Number", "Holder Name", "Account Balance");
        System.out.println("--------------------------------------------------------");
    }

}

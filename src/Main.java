import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankOperations operations = new BankOperations();
        long accNo;
        int choice;

        do {
            choice = operations.mainMenu(sc);
            switch (choice) {
                case 1:
                    System.out.println("--- Inside Add Method ---");
                    operations.addAccount(sc);
                    break;
                case 2:
                    System.out.println("--- Inside ViewAcc Method ---");
                    operations.viewAccounts();
                    break;
                case 3:
                    System.out.println("--- Inside Deposit Method ---");
                    System.out.print("Enter Your Account Number: ");
                    accNo = sc.nextInt();
                    operations.depositMoney(sc, accNo);
                    break;
                case 4:
                    System.out.println("--- Inside Withdraw Method ---");
                    System.out.print("Enter Your Account Number: ");
                    accNo = sc.nextInt();
                    operations.withdrawMoney(sc, accNo);
                    break;
                case 5:
                    System.out.println("--- Inside CheckBal Method ---");
                    System.out.print("Enter Your Account Number: ");
                    accNo = sc.nextInt();
                    operations.checkBalance(accNo);
                    break;
                case 6:
                    System.out.println("--- Inside TransferMoney Method ---");
                    System.out.println("---------- this feature is under development ----------");
                    break;
                case 7:
                    System.out.println("--- Inside DeleteAcc Method ---");
                    System.out.print("Enter Your Account Number: ");
                    accNo = sc.nextInt();
                    operations.deleteAccount(accNo, sc);
                    break;
                case 8:
                    System.out.println("Exiting System 👋");
                    break;
                default:
                    System.out.println("Incorrect Choice...");
            }
        } while (choice != 8);

        sc.close();
    }
}


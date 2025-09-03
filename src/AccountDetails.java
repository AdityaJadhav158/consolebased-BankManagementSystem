//@SuppressWarnings("ALL")
public class AccountDetails {

    private long accNo;
    private String accHolderName;
    private double initialBal;
    private int passKey;

    public AccountDetails(long accNo, String accHolderName, int passKey, double initialBal) {
        this.accHolderName = accHolderName;
        this.accNo = accNo;
        this.initialBal = initialBal;
        this.passKey = passKey;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getInitialBal() {
        return initialBal;
    }

    public void setInitialBal(double initialBal) {
        this.initialBal = initialBal;
    }

    public int getPassKey() {
        return passKey;
    }

    public void setPassKey(int passKey) {
        this.passKey = passKey;
    }

    @Override
    public String toString() {
        return String.format("%-18d %-20s %-15.4f%n", getAccNo(), getAccHolderName(), getInitialBal());
    }
}

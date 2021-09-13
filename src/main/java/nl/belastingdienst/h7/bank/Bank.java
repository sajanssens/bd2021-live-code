package nl.belastingdienst.h7.bank;

public class Bank {

    private Account account1;
    private Account account2;

    public boolean transfer(Account from, Account to, double amount) {
        return false;
    }

    public long getTotalAmount() {
        return 0;
    }

    public void setAccount1(Account account1) {
        this.account1 = account1;
    }

    public void setAccount2(Account account2) {
        this.account2 = account2;
    }
}

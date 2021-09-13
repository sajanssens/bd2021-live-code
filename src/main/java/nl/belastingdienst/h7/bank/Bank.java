package nl.belastingdienst.h7.bank;

import java.util.ArrayList;

public class Bank {

    // private Account account1;
    // private Account account2;

    // private Account[] accounts;
    private ArrayList<Account> accounts = new ArrayList<>();

    public boolean transfer(Account from, Account to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
        return true;
    }

    public double getTotalAmount() {
        // return account1.getBalance() + account2.getBalance();
        double total = 0;

        for (Account a : accounts) {
            double balance = a.getBalance();
            total += balance;
        }

        return total;
    }

    // public void setAccount1(Account account1) {
    //     this.account1 = account1;
    // }
    //
    // public void setAccount2(Account account2) {
    //     this.account2 = account2;
    // }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}

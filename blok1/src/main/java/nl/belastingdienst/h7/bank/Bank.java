package nl.belastingdienst.h7.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    // precies twee accounts:
    // private Account account1;
    // private Account account2;

    // many accounts:
    // private Account[] accounts = new Account[10];    // optie 1: array
    private List<Account> accounts = new ArrayList<>(); // optie 2: nieuwe lege lijst

    public void transfer(Account from, Account to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public double getTotalAmount() {
        // return account1.getBalance() + account2.getBalance();
        double total = 0;

        for (Account a : accounts) { // for each
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

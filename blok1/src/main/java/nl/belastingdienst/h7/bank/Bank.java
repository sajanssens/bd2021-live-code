package nl.belastingdienst.h7.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public void transfer(Account from, Account to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public double getTotalAmount() {
        double total = 0;

        for (Account a : accounts) { // for each
            double balance = a.getBalance(); // hier maakt mijn code een uitstapje naar een andere class
            total += balance;
        }

        return total;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

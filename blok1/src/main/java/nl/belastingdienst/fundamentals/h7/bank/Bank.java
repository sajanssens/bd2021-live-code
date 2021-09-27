package nl.belastingdienst.fundamentals.h7.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements Iterable<Account> {

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

    @Override
    public Iterator<Account> iterator() {
        return new Iterator<>() {

            int counter = 0;

            @Override public boolean hasNext() {
                return counter < accounts.size();
            }

            @Override public Account next() {
                Account account = accounts.get(counter);
                counter++;
                return account;
            }
        };
    }
}

package nl.belastingdienst.fundamentals.h7.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

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

    public List<Account> filterByBalance(int bal) {
        List<Account> filtered = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getBalance() > bal) {
                filtered.add(account);
            }
        }
        return filtered;
    }

    public List<Account> filterByNr() {
        List<Account> filtered = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getNr().startsWith("NL")) {
                filtered.add(account);
            }
        }
        return filtered;
    }

    public List<Account> filterByNrLength() {
        List<Account> filtered = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getNr().length() <= 3) {
                filtered.add(account);
            }
        }
        return filtered;
    }

    public List<Account> filter(Predicate<Account> voorwaarde) {
        List<Account> filtered = new ArrayList<>();
        for (Account account : accounts) {
            if (voorwaarde.test(account)) {
                filtered.add(account);
            }
        }
        return filtered;
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

            @Override
            public boolean hasNext() {
                return counter < accounts.size();
            }

            @Override
            public Account next() {
                Account account = accounts.get(counter);
                counter++;
                return account;
            }
        };
    }
}

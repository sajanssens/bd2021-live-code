package nl.belastingdienst.fundamentals.h7.bank;

public class Account {

    private String nr;
    private double balance;

    public void deposit(double amount) {
        // this.balance = this.balance + amount;
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("Negatief saldo is niet toegestaan.");
        } else {
            // this.balance = this.balance - amount;
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String getNr() {
        return nr;
    }
}

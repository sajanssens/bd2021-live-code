package nl.belastingdienst.h7.bank;

public class Account {

    private double balance;

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public double getBalance(){
        return this.balance;
    }

}

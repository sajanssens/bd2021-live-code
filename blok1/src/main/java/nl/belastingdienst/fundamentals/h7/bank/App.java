package nl.belastingdienst.fundamentals.h7.bank;

public class App {

    public static void main(String[] args) {
        Bank bank = new Bank(); // iterable = itereerbaar = je kunt er doorheen lopen

        for (Account a : bank) {
            System.out.println(a);
        }

        bank.filter(a -> a.getNr().length() <= 3);
        bank.filter(a -> a.getNr().startsWith("NL"));
    }
}

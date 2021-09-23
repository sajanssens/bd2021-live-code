package nl.belastingdienst.fundamentals.h7.bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeBalanceExceptionIsThrown() {
        Account a = new Account();
        a.deposit(100);
        a.withdraw(200); // hier klapt ie eruit.

        // assertThatException(...) ???

        // dit wordt nooit meer uitgevoerd
        // dus geen asserts mogelijk
        // daarom expect in de @Test
    }

    @Test
    public void whenBalanceBecomesZeroItIsAllowed() {
        Account a = new Account();
        a.deposit(100);
        a.withdraw(100);

        assertEquals(0, a.getBalance(), 0.1);
    }

    @Test
    public void whenBalanceStaysPositiveAfterWithdrawItIsAllowed() {
        Account a = new Account();
        a.deposit(100);
        a.withdraw(50);

        assertEquals(50, a.getBalance(), 0.1);
    }
}

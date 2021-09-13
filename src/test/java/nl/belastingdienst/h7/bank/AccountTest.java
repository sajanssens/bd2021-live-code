package nl.belastingdienst.h7.bank;

import org.junit.Test;

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
}

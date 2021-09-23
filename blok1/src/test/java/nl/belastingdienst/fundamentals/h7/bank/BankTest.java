package nl.belastingdienst.fundamentals.h7.bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

// Unit test: alle dependencies afsnijden en vervangen met mocks (dummies, met dummiegedrag)
public class BankTest {

    @Test
    public void getTotalAmountTest() {
        // given
        Bank bank = new Bank();
        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);

        bank.addAccount(account1);
        bank.addAccount(account2);

        // when
        when(account1.getBalance()).thenReturn(100d);
        when(account2.getBalance()).thenReturn(200d);

        double totalAmount = bank.getTotalAmount();

        // then
        assertEquals(300d, totalAmount, 0.1d);

        verify(account1, times(1)).getBalance(); // test dat van account1 1x de getBalance is aangeroepen
        verify(account2, times(1)).getBalance();
    }
}

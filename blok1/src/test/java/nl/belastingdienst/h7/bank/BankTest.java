package nl.belastingdienst.h7.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

// Unit test: alle dependencies afsnijden en vervangen met mocks (dummies, met dummiegedrag)
public class BankTest {

    private Bank target;

    @Before
    public void setUp() throws Exception {
        target = new Bank();
    }

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
        verify(account1, times(1)).getBalance();
        verify(account2, times(1)).getBalance();
    }
}

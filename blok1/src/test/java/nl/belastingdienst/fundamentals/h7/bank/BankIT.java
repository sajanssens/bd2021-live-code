package nl.belastingdienst.fundamentals.h7.bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Integratietest want meerdere klasses betrokken.
public class BankIT {

    @Test
    public void getTotalAmountTest() {
        // given
        Bank bank = new Bank();
        Account rekeningVanBram = new Account();
        Account rekeningVanMatthijs = new Account();

        bank.addAccount(rekeningVanBram);
        bank.addAccount(rekeningVanMatthijs);

        rekeningVanBram.deposit(200);
        rekeningVanMatthijs.deposit(200);

        // when
        double totalAmount = bank.getTotalAmount();

        // then
        assertEquals(400, totalAmount, 0.1);
    }

    @Test
    public void whenTransferTheTransactionIsValid() {
        // given
        Bank bank = new Bank();
        Account rekeningVanBram = new Account();
        Account rekeningVanMatthijs = new Account();

        bank.addAccount(rekeningVanBram);
        bank.addAccount(rekeningVanMatthijs);

        rekeningVanBram.deposit(200);
        rekeningVanMatthijs.deposit(200);

        // when
        bank.transfer(rekeningVanBram, rekeningVanMatthijs, 100);

        // then
        assertEquals(100, rekeningVanBram.getBalance(), 0.1);
        assertEquals(300, rekeningVanMatthijs.getBalance(), 0.1);

        double totalAmount = bank.getTotalAmount();
        assertEquals(400, totalAmount, 0.1);
    }

}

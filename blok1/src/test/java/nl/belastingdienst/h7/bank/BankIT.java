package nl.belastingdienst.h7.bank;

import org.junit.Assert;
import org.junit.Test;

// Integratietest want meerdere klasses betrokken.
public class BankIT {

    @Test
    public void whenTransferTheTransactionIsValid() {
        Bank bank = new Bank();
        Account rekeningVanBram = new Account();
        Account rekeningVanMatthijs = new Account();

        bank.addAccount(rekeningVanBram);
        bank.addAccount(rekeningVanMatthijs);

        rekeningVanBram.deposit(200);
        rekeningVanMatthijs.deposit(200);

        bank.transfer(rekeningVanBram, rekeningVanMatthijs, 100);

        Assert.assertEquals(100, rekeningVanBram.getBalance(), 0.1);
        Assert.assertEquals(300, rekeningVanMatthijs.getBalance(), 0.1);

        double totalAmount = bank.getTotalAmount();
        Assert.assertEquals(400, totalAmount, 0.1);
    }

}

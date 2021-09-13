package nl.belastingdienst.h7.bank;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {

    @Test
    public void whenTransferTheTransactionIsValid() {
        Bank bank = new Bank();
        Account rekeningVanBram = new Account();
        Account rekeningVanMatthijs = new Account();

        bank.setAccount1(rekeningVanBram);
        bank.setAccount2(rekeningVanMatthijs);

        rekeningVanBram.deposit(200);
        rekeningVanMatthijs.deposit(200);

        bank.transfer(rekeningVanBram, rekeningVanMatthijs, 100);

        Assert.assertEquals(100, rekeningVanBram.getBalance(), 0.1);
        Assert.assertEquals(300, rekeningVanMatthijs.getBalance(), 0.1);
    }
}
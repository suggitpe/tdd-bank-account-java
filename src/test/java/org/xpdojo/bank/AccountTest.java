package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.xpdojo.bank.Account.emptyAccount;
import static org.xpdojo.bank.Money.anAmountOf;

public class AccountTest {

    @Test
    public void createsZeroBalanceAccountsOnCreation(){
        Account account = emptyAccount();
        assertThat(account.balance()).isEqualTo(anAmountOf(0.0));
    }

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        Account account = emptyAccount();
        account.deposit(anAmountOf(10.0));
        assertThat(account.balance()).isEqualTo(anAmountOf(10.0));
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance(){
        Account account = Account.anAccountWithABalanceOf(anAmountOf(35.0));
        account.withdraw(anAmountOf(25.0));
        assertThat(account.balance()).isEqualTo(anAmountOf(10.0));
    }
}

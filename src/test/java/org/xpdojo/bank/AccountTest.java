package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.xpdojo.bank.Account.anAccountWithABalanceOf;
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
        Account account = anAccountWithABalanceOf(anAmountOf(35.0));
        account.withdraw(anAmountOf(25.0));
        assertThat(account.balance()).isEqualTo(anAmountOf(10.0));
    }

    @Test
    public void throwsExceptionWhenYouTryToWithdrawMoreThanBalance(){
        Account account = anAccountWithABalanceOf(anAmountOf(30.0));
        assertThatThrownBy(
                () -> account.withdraw(anAmountOf(40.0))
        ).isInstanceOf(Exception.class);
    }

    @Test
    public void canTransferFromOneAccountToAnother(){
        Account giver = anAccountWithABalanceOf(anAmountOf(100.0));
        Account receiver = anAccountWithABalanceOf(anAmountOf(25.0));
        giver.transfer(anAmountOf(25.0)).to(receiver);
        assertThat(giver.balance()).isEqualTo(anAmountOf(75.0));
        assertThat(receiver.balance()).isEqualTo(anAmountOf(50.0));
    }
}

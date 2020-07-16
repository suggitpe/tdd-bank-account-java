package org.xpdojo.bank;

public class Account {

    private Money balance;

    public Account(Money anAmount) {
        balance = anAmount;
    }

    public static Account emptyAccount() {
        return new Account(Money.anAmountOf(0.0));
    }

    public void deposit(Money money){
        balance = balance.add(money);
    }

    public Money balance() {
        return balance;
    }
}

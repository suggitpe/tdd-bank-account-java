package org.xpdojo.bank;

public class Account {

    private Money balance;

    public Account(Money initialBalance) {
        balance = initialBalance;
    }

    public static Account emptyAccount() {
        return new Account(Money.anAmountOf(0.0));
    }

    public static Account anAccountWithABalanceOf(Money initialBalance) {
        return new Account(initialBalance);
    }

    public void deposit(Money money){
        balance = balance.add(money);
    }

    public void withdraw(Money money) {
        if(money.isGreaterThan(balance))
            throw new IllegalStateException("Trying to withdrawn more than the balance");
        balance = balance.less(money);
    }

    public Money balance() {
        return balance;
    }
}

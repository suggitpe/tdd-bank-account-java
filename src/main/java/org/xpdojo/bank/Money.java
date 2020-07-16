package org.xpdojo.bank;

import java.util.Objects;

/**
 * Immutable class to represent Money as a concept.
 * This class should have no accessor methods.
 */
public class Money {
    private final double amount;

    public Money(double anAmount) {
        amount = anAmount;
    }

    public static Money anAmountOf(double anAmount) {
        return new Money(anAmount);
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    public Money less(Money money) {
        return new Money(amount - money.amount);
    }

    public boolean isGreaterThan(Money balance) {
        return amount > balance.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}

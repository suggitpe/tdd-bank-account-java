package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.xpdojo.bank.Money.anAmountOf;

public class MoneyTest {

    @Test
    public void addTwoAmountsTogether(){
        Money amount = anAmountOf(24.0).add(anAmountOf(12.0));
        assertThat(amount).isEqualTo(anAmountOf(36.0));
    }

    @Test
    public void takeOneAmountFromAnother(){
        Money amount = anAmountOf(24.0).less(anAmountOf(12.0));
        assertThat(amount).isEqualTo(anAmountOf(12.0));
    }

    @Test
    public void canBeComapredToAGreaterAmount(){
        assertThat(anAmountOf(50.0).isGreaterThan(anAmountOf(25.0))).isTrue();
    }
}

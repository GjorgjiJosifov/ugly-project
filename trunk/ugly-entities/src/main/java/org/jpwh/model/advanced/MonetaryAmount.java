package org.jpwh.model.advanced;

import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount {

    /*
 The class does not need a special constructor, you can make it immutable, even with
        <code>final</code> fields, as your code will be the only place an instance is created.
     */
    protected final BigDecimal value;
    protected final Currency currency;

    public MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    /*
 You should implement the <code>equals()</code> and <code>hashCode()</code>
        methods, and compare monetary amounts "by value".
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonetaryAmount)) return false;

        final MonetaryAmount monetaryAmount = (MonetaryAmount) o;

        if (!value.equals(monetaryAmount.value)) return false;
        if (!currency.equals(monetaryAmount.currency)) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = value.hashCode();
        result = 29 * result + currency.hashCode();
        return result;
    }

    /*
 You will need a <code>String</code> representation of a monetary
        amount. Implement the <code>toString()</code> method and a static method to
        create an instance from a <code>String</code>.
     */
    public String toString() {
        return getValue() + " " + getCurrency();
    }

    public static MonetaryAmount fromString(String s) {
        String[] split = s.split(" ");
        return new MonetaryAmount(
            new BigDecimal(split[0]),
            Currency.getInstance(split[1])
        );
    }
}


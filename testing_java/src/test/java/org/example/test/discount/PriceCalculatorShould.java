package org.example.test.discount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void total_zero_where_there_are_not_prices() {
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(),is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(),is(25.7));
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(11.2);
        calculator.addPrice(23.5);

        calculator.setDiscount(50);
        assertThat(calculator.getTotal(),is(17.35));
    }
}
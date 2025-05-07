package org.example.test.discount;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private double total;
    private List<Double> prices = new ArrayList<>();
    private double discount;

    public double getTotal() {
        for(double price : prices){
            total += price;
        }

        total = total-(total * (discount/100));
        return  Math.round(total*1000.0)/1000.0;
    }



    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

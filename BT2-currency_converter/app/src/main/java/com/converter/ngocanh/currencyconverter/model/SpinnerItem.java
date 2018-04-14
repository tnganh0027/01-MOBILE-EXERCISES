package com.converter.ngocanh.currencyconverter.model;

import java.io.Serializable;

/**
 * Created by ngoca on 4/14/2018.
 */

public class SpinnerItem implements Serializable {
    private int timesUsed;
    private String currencySymbol;

    public SpinnerItem(String currencySymbol) {
        this.timesUsed = 0;
        this.currencySymbol = currencySymbol;
    }

    public void increment() {
        timesUsed++;
    }

    public void decrement() {
        timesUsed--;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
}

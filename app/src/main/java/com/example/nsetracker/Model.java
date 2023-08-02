package com.example.nsetracker;

public class Model {

String names,prices,prevclose,pricechange,perchange;

    public String getPricechange() {
        return pricechange;
    }

    public void setPricechange(String pricechamge) {
        this.pricechange = pricechamge;
    }

    public String getPerchange() {
        return perchange;
    }

    public void setPerchange(String perchange) {
        this.perchange = perchange;
    }

    public String getPrevclose() {
        return prevclose;
    }

    public void setPrevclose(String prevclose) {
        this.prevclose = prevclose;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}





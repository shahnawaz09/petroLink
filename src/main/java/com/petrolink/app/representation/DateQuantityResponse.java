package com.petrolink.app.representation;

public class DateQuantityResponse {

    String date;
    long quantity;

    public DateQuantityResponse(String date, long quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

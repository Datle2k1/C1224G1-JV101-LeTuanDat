package org.example.casestudymodule3.model;

public class Order {
    private int order_id;
    private int customer_id;
    private String order_date;
    private int total_price;
    private int is_paid;

    public Order() {
    }

    public Order(int order_id, int customer_id, String order_date, int total_price, int status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.is_paid = status;
    }

    public Order(int customer_id, String order_date, int total_price, int is_paid) {
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.is_paid = is_paid;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }
}

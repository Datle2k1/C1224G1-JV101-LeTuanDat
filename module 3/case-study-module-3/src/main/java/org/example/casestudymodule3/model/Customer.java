package org.example.casestudymodule3.model;

public class Customer {
    private int customer_id;
    private String name;
    private String email;
    private String password;
    private String in_game;

    public Customer() {
    }

    public Customer(String name, String email, String password, String in_game) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.in_game = in_game;
    }

    public Customer(int customer_id, String name, String email, String password, String in_game) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.in_game = in_game;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIn_game() {
        return in_game;
    }

    public void setIn_game(String in_game) {
        this.in_game = in_game;
    }
}

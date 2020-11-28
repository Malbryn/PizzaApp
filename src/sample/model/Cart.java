package sample.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Pizza> order = new ArrayList<Pizza>();
    private Customer customer;

    public Cart() {
        this.order = new ArrayList<Pizza>();
    }

    public Cart(ArrayList<Pizza> order) {
        this.order = order;
    }

    public Cart(ArrayList<Pizza> order, Customer customer) {
        this.order = order;
        this.customer = customer;
    }

    public ArrayList<Pizza> getOrder() {
        return this.order;
    }

    public void setOrder(ArrayList<Pizza> order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addOrder(Pizza newPizza) {
        this.order.add(newPizza);
    }
}

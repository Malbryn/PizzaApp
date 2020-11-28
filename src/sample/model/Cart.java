package sample.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Pizza> order;
    private Customer customer;
    private int total = 0;

    public Cart() {
        this.order = new ArrayList<>();
    }

    public Cart(ArrayList<Pizza> order) {
        this.order = order;
        calculateTotal();
    }

    public Cart(ArrayList<Pizza> order, Customer customer) {
        this.order = order;
        this.customer = customer;
        calculateTotal();
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
        this.total += newPizza.getPrice();
    }

    private void calculateTotal() {
        for (Pizza p : this.order) {
            this.total += p.getPrice();
        }
    }

    public int getTotal() {
        return this.total;
    }
}

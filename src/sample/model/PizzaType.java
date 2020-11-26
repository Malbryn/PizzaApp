package sample.model;

public enum PizzaType {
    MARGHERITA("Margaréta", 1200),
    PEPPERONI("Szalámis", 1350),
    MEAT("Húsimádó", 1400),
    BBQ("BBQ", 1400),
    HAWAIIAN("Hawaii", 1350),
    MUSHROOM("Gombás", 1300);

    private String name;
    private int price;

    PizzaType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}

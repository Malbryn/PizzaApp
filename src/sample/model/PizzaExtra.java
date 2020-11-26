package sample.model;

public enum PizzaExtra {
    PEPPERONI("Szalámi", 150),
    BACON("Bacon", 250),
    OLIVES("Olívabogyó", 100),
    HAM("Sonka", 150),
    CHEESE("Sajt", 100),
    ONION("Hagyma", 100);

    private String name;
    private int price;

    PizzaExtra(String name, int price) {
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

package sample.model;

public enum PizzaStyle {
    THIN("Vékony"),
    THICK("Vastag"),
    STUFFED_CRUST("Sajttal töltött");

    private String name;

    PizzaStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

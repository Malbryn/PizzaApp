package sample.model;

public enum PizzaSize {
    SMALL(28, 0.8),
    MEDIUM(32, 1),
    LARGE(45, 1.5);

    private int size;
    private double priceCoeff;

    PizzaSize(int size, double priceCoeff) {
        this.size = size;
        this.priceCoeff = priceCoeff;
    }

    public int getSize() {
        return this.size;
    }

    public double getPriceCoeff() {
        return this.priceCoeff;
    }
}

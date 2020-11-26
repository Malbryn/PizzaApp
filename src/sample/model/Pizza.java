package sample.model;

import java.util.ArrayList;

public class Pizza {
    private PizzaStyle style;
    private PizzaSize size;
    private PizzaType type;
    private ArrayList<PizzaExtra> extraToppings;
    private int price = 0;

    public Pizza(PizzaStyle style, PizzaSize size, PizzaType type, ArrayList<PizzaExtra> extraToppings) {
        this.style = style;
        this.size = size;
        this.type = type;
        this.extraToppings = extraToppings;
        this.price = this.calculatePrice();
    }

    private int calculatePrice() {
        // price = type * size + extra
        int basePrice = this.type.getPrice();
        double sizeCoeff = this.size.getPriceCoeff();
        int extra = 0;

        if (this.extraToppings.size() != 0) {
            for (PizzaExtra e : this.extraToppings) {
                extra += e.getPrice();
            }
        }

        return (int) (basePrice * sizeCoeff + extra);
    }

    public int getPrice() {
        return this.price;
    }
}

package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Business {
    private String description;
    private int price;

    /**
     * Constructor for Shop object.
     * @param name String, name of shop
     * @param description String, description of shop
     * @param price int, price
     */
    public Shop(String name, String description, int price) {
        super(name);
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Shop: " +
                "name '" + this.getName() + '\'' +
                ", description '" + description + '\'' +
                ", price " + price;
    }
}

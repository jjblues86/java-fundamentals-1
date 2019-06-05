package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Business {
    private String name;
    private String description;
    private int stars;
    private int price;
    private static int totalStars;
    private static List<Review> reviewList = new ArrayList<>();

    /**
     * Constructor for Shop object.
     * @param name String, name of shop
     * @param description String, description of shop
     * @param price int, price
     */
    public Shop(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stars = 0;
    }

    /**
     * Adds Review to list to track for this business,
     * sends this Business to review for it to track.
     * @param review Review object
     */
    @Override
    public void addReview(Review review) {
        //add Review to list
        reviewList.add(review);

        //increment total number of stars
        totalStars += review.getStars();

        //set star average
        setStarsAverage();

        //set reference of the passed in Review to hold business object
        review.setBusiness(this);
    }

    //helper method to set star average
    private void setStarsAverage() {
        stars = totalStars/(reviewList.size());
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "Shop: " +
                "name '" + name + '\'' +
                ", description '" + description + '\'' +
                ", price " + price;
    }
}

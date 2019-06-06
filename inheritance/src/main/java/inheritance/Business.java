package inheritance;

import inheritance.Interfaces.ReviewInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract parent class of Business
 * that implements a Review Interface.
 * The method from interface is implemented in the subclasses.
 *
 */

public abstract class Business implements ReviewInterface {
    private String name;
    private static int totalStars;
    private int stars;
    private static List<Review> reviewList = new ArrayList<>();

    /**
     * Constructor that accepts name.
     * @param name String name
     */
    public Business(String name) {
        this.name = name;
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

    /***GETTERS****/
    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Review> getResultList() {
        return this.reviewList;
    }

    @Override
    public String toString() {
        return "Business " +
                "name='" + name + '\'' +
                ", stars=" + stars;
    }
}

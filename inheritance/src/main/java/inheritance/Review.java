package inheritance;

public class Review {
    private String body;
    private String author;
    private int stars;
    private Business business;
    private String movie;

    /**
     * Constructor for Review object.
     * Accepts Shop, Restaurant, and Theater without movie title specified.
     * @param body text, String, the actual review content
     * @param name String, who wrote review
     * @param userStars int, number of stars
     */
    public Review(String body, String name, int userStars) {
        this.body = body;
        this.author = name;
        validateStars(userStars);
    }

    /**
     * Constructor for Review of Theater that includes movie.
     * @param body text, String, actual review content
     * @param author String, author of review
     * @param userStars int, number of stars
     * @param movie String, movie title
     */
    public Review(String body, String author, int userStars, String movie) {
        this.body = body;
        this.author = author;
        validateStars(userStars);
        this.movie = movie;
    }

    //validates number of stars to be within range of 0 - 6
    private void validateStars(int stars) {
        if(stars < 0 || stars > 6) {
            throw new IllegalArgumentException("Stars must be an integer between 0 - 5.");
        }
        this.stars = stars;
    }

    /**
     * Getter for Body.
     * @return String, body of review
     */
    public String getBody() {
        return body;
    }

    /**
     * Getter for author.
     * @return String, who wrote review
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter for number of stars.
     * @return String, number of stars.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Setter. Sets this instance of Review to the Business
     * it is about.
     * @param business Business object - holds instance of Business subclass
     */
    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return this.business;
    }

    @Override
    public String toString() {
        return "Review: " + body + '\'' +
                ", by: '" + author + '\'' +
                ", stars: " + stars;

    }

}

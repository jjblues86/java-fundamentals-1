package inheritance;

public class Review {
    private String body;
    private String author;
    private int stars;

    public Review(String body, String author, int userStars) {
        this.body = body;
        this.author = author;
        validateStars(userStars);
    }

    private void validateStars(int stars) {
        if(stars < 0 || stars > 6) {
            throw new IllegalArgumentException("Stars must be an integer between 0 - 5.");
        }
        this.stars = stars;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "Review: " + body + '\'' +
                ", by: '" + author + '\'' +
                ", stars: " + stars;
    }
}

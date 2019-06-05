package inheritance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Theater extends Business {
    private String name;
    private int stars;
    private static int totalStars;
    //set used here to not have duplicate movie titles
    private static Set<String> movies = new HashSet<>();
    private static List<Review> reviewList = new ArrayList<>();

    /**
     * Constructor
     * @param name String
     */
    public Theater(String name) {
        this.name = name;
        stars = 0;
    }

    public Theater(String name, String movie) {
        this.name = name;
        movies.add(movie);
        stars = 0;
    }

    //if movie already exists, will throw user to let user know
    private void addMovie(String movie) {
        if(movies.contains(movie)) {
            throw new IllegalArgumentException("This movie is already listed");
        }
        movies.add(movie);
    }

    //if movie doesn't exist, will throw error to let user know
    private void removeMovie(String movie) {
        if(!movies.contains(movie)) {
            throw new IllegalArgumentException("This movie does not play at this theater");
        }
        movies.remove(movie);

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

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public static Set<String> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        StringBuilder movieList = new StringBuilder();
        movieList.append("Movies that play at this theater: ");
        if(movies.size() > 0) {
            for(String movie : movies) {
                movieList.append("\n").append(movie);
            }
        } else {
            movieList.append("none");
        }

        return "Theater: " +
                "name='" + name + '\''
                + movieList;
    }
}

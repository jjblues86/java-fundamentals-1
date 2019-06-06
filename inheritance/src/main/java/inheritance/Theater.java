package inheritance;

import java.util.HashSet;
import java.util.Set;

public class Theater extends Business {

    //set used here to not have duplicate movie titles
    private Set<String> movies;

    /**
     * Constructor
     * @param name String
     */

    public Theater(String name) {
        super(name);
        movies =  new HashSet<>();
    }

    public Theater(String name, String movie) {
        super(name);
        movies =  new HashSet<>();
        movies.add(movie);
    }

    //if movie already exists, will throw user to let user know
    public void addMovie(String movie) {
        if(movies.contains(movie)) {
            throw new IllegalArgumentException("This movie is already listed");
        }
        movies.add(movie);
    }

    //if movie doesn't exist, will throw error to let user know
    public void removeMovie(String movie) {
        if(!movies.contains(movie)) {
            throw new IllegalArgumentException("This movie does not play at this theater");
        }
        movies.remove(movie);

    }

    public Set<String> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        StringBuilder movieList = new StringBuilder();
        movieList.append("\nMovies that play at this theater: ");
        if(movies.size() > 0) {
            for(String movie : movies) {
                movieList.append("\n").append(movie);
            }
        } else {
            movieList.append("none");
        }

        return "Theater: " +
                "name ='" + this.getName() + '\''
                + movieList;
    }
}

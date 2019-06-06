package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheaterTest {
    private Theater theater1;
    private Theater theater2;


    @Before
    public void init() {

        //two theater instances
        theater1 = new Theater("Cinemark");
        theater2 = new Theater("Ruston Way", "Pokemon Detective Pikachu");
    }

    @Test
    public void checkJustInstantiated() {
        assertSame("Restaurant should have 0 stars after instantiation.", 0,
                theater1.getStars());
        assertSame("Name should be din tai fung", "Cinemark", theater1.getName());
        assertEquals(
                "Theater toString should match 'Theater: name ='Cinemark'\nMovies that play at this theater: \n" +
                        "Pokemon Detective Pikachu'",
                "Theater: name ='Cinemark'\n" +
                        "Movies that play at this theater: \n" +
                        "Pokemon Detective Pikachu", theater1.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void theaterWithoutReviews() {
        theater1.removeMovie("Pokemon Detective Pikachu");
    }


    @Test
    public void addReviewToTheater() {
        //review without movie
        Review review1 = new Review("cool", "j", 2);
        theater1.addReview(review1);

        //theater doesn't have any movies listed yet
        assertEquals("No movies listed yet",
                "Theater: name ='Cinemark'\nMovies that play at this theater: none",
                theater1.toString());

        String result = "Theater: name ='Cinemark'\n" +
                "Movies that play at this theater: \n" +
                "Pokemon Detective Pikachu";

        //add movie
        theater1.addMovie("Pokemon Detective Pikachu");

        //test for business ie theater name
        assertEquals("Call get business + get name should retrieve theater 1 name - Theater: name ='Cinemark'\n" +
                        "Movies that play at this theater: \n" +
                        "Pokemon Detective Pikachu",
                result,
                review1.getBusiness().toString());

        //test that duplicate movie does not get added
        theater2.addReview(review1);
        int numOfMovies = theater2.getMovies().size();
        assertEquals("Movies at theater 2 should still be one", 1, numOfMovies);

    }

    @Test (expected = IllegalArgumentException.class)
    public void removeFromEmpty() {
        theater1.removeMovie("Pokemon Detective Pikachu");
    }
}

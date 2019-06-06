package inheritance;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {
    private Business shop1;
    private Business shop2;

    @Before
    public void init() {
        //two shop instances
        shop1 = new Shop("shop1", "quaint and affordable", 2);
        shop2 = new Shop("shop2", "expensive, not worth it", 5);
    }

    @Test
    public void addOneReview() {
        assertEquals("Size of review list should be 0", 0, shop1.getResultList().size());
        Review review1 = new Review("too expensive, small, poor service", "p", 0);
        shop1.addReview(review1);

        assertEquals("Size of review list should now be 1",1, shop1.getResultList().size());

        assertEquals("Review should be attached to shop",
                "Shop: name 'shop1', description 'quaint and affordable', price 2",
                review1.getBusiness().toString());

        assertTrue(shop1.getResultList().contains(review1));
    }

    @Test
    public void addManyReviews() {
        addOneReview();
        Review review2 = new Review("meh", "d", 1);
        Review review3 = new Review("alright", "l", 2);

        shop1.addReview(review2);
        shop1.addReview(review3);

        assertEquals("Size of review list should now be 3", 3, shop1.getResultList().size());

        assertTrue(shop1.getResultList().contains(review2));
        assertTrue(shop1.getResultList().contains(review3));

        assertEquals("Reviewer name should be d", "d", review2.getBusiness().getName());
    }
}

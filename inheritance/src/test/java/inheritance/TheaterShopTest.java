package inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheaterShopTest {
    private Theater theater1;
    private Theater theater2;
    private Shop shop1;
    private Shop shop2;

    @Before
    public void init() {
        theater1 = new Theater("Cinemark");
        theater2 = new Theater("Ruston Way", "Pokemon Detective Pikachu");
        shop1 = new Shop("shop1", "quaint and affordable", 2);
        shop2 = new Shop("shop2", "expensive, not worth it", 5);
    }

    @Test
    public void checkJustInstantiatedRestaurant() {
        assertSame("Restaurant should have 0 stars after instantiation.", 0,
                theater1.getStars());
        assertSame("Name should be din tai fung", "Cinemark", theater1.getName());
        assertTrue("To string method for din tai fung should contain name",
                theater1.toString().contains("name"));
        assertEquals("To string for dintaifung should b Restaurant name: 'din tai fung', stars: 0, price: 2",
                "Restaurant name: 'din tai fung', stars: 0, price: 2", theater1.toString());
    }
}

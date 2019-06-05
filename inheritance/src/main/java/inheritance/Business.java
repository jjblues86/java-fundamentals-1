package inheritance;

import inheritance.Interfaces.ReviewInterface;

/**
 * This is an abstract parent class of Business
 * that implements a Review Interface.
 * The method from interface is implemented in the subclasses.
 *
 */

public abstract class Business implements ReviewInterface {
    private String name;

}

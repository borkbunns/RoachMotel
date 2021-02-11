/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class makes sure that all classes that use it will have
 * a getDescription method (which will also help us get a list description of the amenities that a Room uses).
 */
public abstract class Amenities extends Room {
    /** The decorator for our amenities will be added to our rooms **/
    public abstract String getDescription();
}
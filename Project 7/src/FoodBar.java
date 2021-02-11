/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a FoodBar. It adds $10 each night to the roach colony's total bill, updates
 * the Room's description of amenities, and returns room number & colony number.
 */
public class FoodBar extends Amenities{
    /** Decorate our room with the amenity **/
    protected Room room;
    /** Cost of food bar is $10 a night **/
    public static final double COST = 10;

    /**
     * Decorating room with the food bar
     * @param r the room to decorate with
     */
    public FoodBar(Room r){
        this.room = r;
    }

    /**
     * Add the amenity to the description of the room
     * @return the updated description
     */
    public String getDescription(){
        return room.getDescription() + ", foodbar";
    }

    /**
     * Getter for the roach colony
     * @return the occupant of the room
     */
    @Override
    public RoachColony getColony() { return room.getColony(); }

    /**
     * Getter for the room number
     * @return the number of the room
     */
    @Override
    public int getRoomNumber() { return room.getRoomNumber(); }

    /**
     * Add the price of the amenity to the total cost
     * @return the added cost
     */
    public double cost() { return room.cost() + COST; }
}
/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents an AutoRefillBar, and it allows us to retrieve the RoachColony, room number, and cost.
 * It also updates the Room's list description of amenities.
 */

public class AutoRefillBar extends Amenities {
    /** Decorate our room with the amenity **/
    protected Room room;
    /** Cost of an auto refill bar is $5 a night **/
    public static final double COST = 5;

    /**
     * Decorating room with the auto refill bar
     * @param r the room to decorate with
     */
    public AutoRefillBar(Room r){
        this.room = r;
    }

    /**
     * Add the amenity to the description of the room
     * @return the updated description
     */
    public String getDescription(){
        return room.getDescription() + ", refillbar";
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
    public double cost(){
        return room.cost() + COST;
    }
}
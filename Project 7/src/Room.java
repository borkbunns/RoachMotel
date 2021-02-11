/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a Room. All room types will need to implement its methods.
 */
public abstract class Room {
    /** The room #, occupant, room type, and amenities of the room **/
    protected String description;
    /** The roach colony in the room **/
    protected RoachColony colony;
    /** The number of the room **/
    protected int roomNumber;

    /**
     * Getter for the room description
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the roach colony
     * @return the occupant of the room
     */
    public RoachColony getColony(){
        return colony;
    }

    /**
     * Getter for the room number
     * @return the number of the room
     */
    public int getRoomNumber() { return roomNumber; }

    /**
     * The total cost of the room is dependent on the type of room as well as the amenities added
     * @return the cost of all factors
     */
    public abstract double cost();
}
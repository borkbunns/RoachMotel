/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a RegularRoom, and it adds $50 to the roach colony's total bill.
 */
public class RegularRoom extends Room {
    /** Price of a Deluxe room is $50 **/
    public static final double COST = 50;

    /**
     * Default constructor of regular room
     */
    public RegularRoom() {
        description = "Regular room for regular roaches";
    }

    /**
     * Regular room with the colony and room number taken
     * @param c the colony checking in
     * @param roomNumber the number of the room
     */
    public RegularRoom(RoachColony c, int roomNumber) {
        colony = c;
        description = "ROOM " + roomNumber + " -> " + colony.getName() + " - " + colony.getPopulation()
                + " occupants | " + "Regular Room";
        this.roomNumber = roomNumber;
    }

    /**
     * Add the price of the room to the total cost
     * @return the added cost
     */
    public double cost() {
        return COST;
    }
}
/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a DeluxeRoom, and it adds $75 to the roach colony's total bill.
 */
public class DeluxeRoom extends Room{
    /** Price of a Deluxe room is $75 **/
    public static final double COST = 75;

    /**
     * Default constructor of deluxe room
     */
    public DeluxeRoom() {
        description = "Deluxe room for deluxe roaches";
    }

    /**
     * Deluxe room with the colony and room number taken
     * @param c the colony checking in
     * @param roomNumber the number of the room
     */
    public DeluxeRoom(RoachColony c, int roomNumber) {
        colony = c;
        description = "ROOM " + roomNumber + " -> " + colony.getName() + " - " + colony.getPopulation()
                + " occupants | " + "Deluxe Room";
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
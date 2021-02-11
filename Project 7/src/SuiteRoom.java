/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a SuiteRoom, and it will add on $100 to the roaches' total bill.
 */
public class SuiteRoom extends Room {
    /** Price of a Suite room is $100 **/
    public static final double COST = 100;

    /**
     * Default constructor of suite room
     */
    public SuiteRoom() {
        description = "A suite";
    }

    /**
     * Suite room with the colony and room number taken
     * @param c the colony checking in
     * @param roomNumber the number of the room
     */
    public SuiteRoom(RoachColony c, int roomNumber) {
        colony = c;
        description = "ROOM " + roomNumber + " -> " + colony.getName() + " - " + colony.getPopulation()
                + " occupants | " + "Suite Room";
        this.roomNumber = roomNumber;
    }

    /**
     * Add the price of the room to the total cost
     * @return the added cost
     */
    public double cost() { return COST; }
}
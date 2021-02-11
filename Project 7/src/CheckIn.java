/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class is a Factory for the rooms. It contains a method that creates and returns a RegularRoom,
 * DeluxeRoom, or SuiteRoom.
 */
public class CheckIn {
    /**
     * The Factory for our rooms
     * @param c the colony checking into the room
     * @param type the type of the room
     * @param roomNumber the room number to take
     * @return one of the 3 types of rooms: Regular, Deluxe, or Suite
     */
    public Room getRoom(RoachColony c, String type, int roomNumber) {
        if (type.equals("Regular")) {
            return new RegularRoom(c, roomNumber);
        }
        else if (type.equals("Deluxe")){
            return new DeluxeRoom(c, roomNumber);
        }
        else if (type.equals("Suite")){
            return new SuiteRoom(c, roomNumber);
        } else {
            return null;
        }
    }
}

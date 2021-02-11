/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a Motel. It displays and keeps track of what rooms are occupied and what rooms are available.
 * When the roaches check in, their desired rooms are created and then decorated with the amenities that they want.
 * When the roaches check out and pay, their receipt will be displayed.
 */
import java.util.ArrayList;
public class Motel {
    /** We want to make sure only 1 motel is created **/
    private static Motel motel;
    /** Our motel will have n amount of available rooms **/
    private ArrayList<Integer> rooms;
    /** Whatever room is occupied will be removed from the room list and added to the occupied rooms**/
    private ArrayList<Room> occupiedRooms;

    /**
     * Private constructor to prevent more than 1 motel
     */
    private Motel(){
        rooms = new ArrayList<>();
        occupiedRooms = new ArrayList<>();
    }

    /**
     * Checks if an instance of a Motel exists and creates it if it doesn't
     * @return the Motel object
     */
    public static Motel getInstance(){
        if(motel == null){
            motel = new Motel();
        }
        return motel;
    }

    /**
     * Create n amount of rooms for the motel
     * @param num the amount of rooms to add to the motel
     */
    public void createRooms(int num){
        for (int i = 1; i <= num; i++) {
            rooms.add(100 + i);
        }
    }

    /**
     * This method will allow a roach colony to check into a room, along with any amenities they would like to add
     * @param colony the roach colony to check in
     * @param roomType one of the 3 types of rooms the colony chooses: Regular, Deluxe, or Suite
     * @param amenities the list of amenities the colony desire to have in their room
     * @return the room created for the roach colony
     */
    public Room checkIn(RoachColony colony, String roomType, ArrayList<String> amenities){
        // Check if a colony has already checked out a room or there is no space left
        for (Room room : occupiedRooms) {
            if (room.getColony() == colony) {
                System.out.println(colony.getName() + " has already checked out a room!");
                return null;
            }
        }
        if (rooms.size() == 0){
            System.out.println("We're sorry, but we're out of rooms!");
            return null;
        }

        // Create the factory for the rooms and create the specified type
        CheckIn check = new CheckIn();
        Room room = check.getRoom(colony, roomType, this.rooms.get(0));
        // Decorating room with the amenities provided
        for (String type : amenities){
            if (type.equals("spa")) {
                room = new Spa(room);
            }
            if(type.equals("shower")) {
                room = new SprayResistantShower(room);
            }
            if (type.equals("foodbar")) {
                room = new FoodBar(room);
            }
            if (type.equals("autorefillbar")) {
                room = new AutoRefillBar(room);
            }
        }

        // Update room vacancy accordingly
        this.rooms.remove(0);
        occupiedRooms.add(room);
        return room;
    }

    /**
     * This method allows a colony to check out of their rooms, paying with their type for however many days they stayed
     * @param r the room to be checked out of
     * @param days the amount of days stayed in the room
     * @param paymentType one of the 2 types of payment to use: RoachPal or MasterRoach
     */
    public void checkOut(Room r, int days, PaymentStrategy paymentType) {
        // Multiply the cost of the room & amenities by the amount of days stayed
        double cost = r.cost() * days;
        System.out.println("--- RECEIPT FOR " + r.getColony().getName() + "---");
        System.out.print("ROOM #" + r.getRoomNumber() + " FOR " + days + " DAYS: ");
        paymentType.pay(cost);
        // Update room vacancy accordingly
        occupiedRooms.remove(r);
        rooms.add(r.getRoomNumber());
    }

    /**
     * Getter for the occupied rooms
     * @return
     */
    public ArrayList<Room> getOccupiedRooms() {
        return occupiedRooms;
    }

    /**
     * String representation of the motel, displaying the available rooms and the occupied rooms and its details
     * @return the available and occupied rooms
     */
    @Override
    public String toString(){
        String motelReport;
        if (rooms.size() == 0) {
            // Display "NO VACANCY" sign when there are no more rooms
            motelReport = "Available rooms : NO VACANCY" + "\n↓ Occupied Rooms ↓\n";
        } else {
            motelReport = "Available rooms : " + rooms.toString() + "\n↓ Occupied Rooms ↓\n";
        }
        // Loop through and display all occupied rooms
        for (Room rooms : occupiedRooms) {
            motelReport += rooms.getDescription() + "\n";
        }
        return motelReport;
    }
}
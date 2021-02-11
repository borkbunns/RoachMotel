/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class tests out all of the other classes to make sure that they correctly work together
 * to create a roach motel. Multiple roach colonies can check into different types of rooms, but none of them
 * can check into rooms that already occupied. The roach colonies also have the option to use hotel amenities, and these costs
 * are calculated in our other classes. When they check out, they can pay choosing from two different forms of payment,
 * and then a receipt will be displayed.
 * Input:
 *    Number of rooms to create
 *    Name, population, and growth rate of a roach colony
 *    Name, email, securityCode (optional), expiration (optional) of roach colony to pay the hotel bill
 *    Desired amenities like spa, foodbar, autorefillbar, shower
 *    Room type like Deluxe, Regular, Suite
 *    Number of days that the roach colony is staying at the hotel
 *
 * Output:
 *   List of available rooms the roaches can check into
 *   Occupied rooms (along with name of roach colony, number of occupants, room type, and list of amenities)
 *   "No Vacancy" sign if there are no available rooms
 *   The new population of a roach colony whenever they party
 *   Receipts whenever the roach colonies pay and check out
 *
 */
import java.util.ArrayList;
public class Tester {
    public static void main(String[] args) {

        // Creating only one instance of the motel with n amount of rooms...
        Motel motel = Motel.getInstance();
        motel.createRooms(5);
        System.out.println(motel);

        // Instantiate our colonies...
        RoachColony rc1 = new RoachColony("Roach #1",100,0.2);
        RoachColony rc2 = new RoachColony("Roach #2",200,0.4);
        RoachColony rc3 = new RoachColony("Roach #3",300,0.6);
        RoachColony rc4 = new RoachColony("Roach #4",400,0.8);
        RoachColony rc5 = new RoachColony("Roach #5",500,2.0);
        RoachColony rc6 = new RoachColony("Roach #6",600,1.5);

        // Instantiate the payments...
        PaymentStrategy pay1 = new MasterRoach("Roach1", "r1@gmail.com","123" ,"1/23");
        PaymentStrategy pay2 = new MasterRoach("Roach2", "r2@gmail.com","456" ,"4/56");
        PaymentStrategy pay3 = new RoachPal("Roach3", "r3@gmail.com");
        PaymentStrategy pay4 = new RoachPal("Roach4", "r4@gmail.com");
        PaymentStrategy pay5 = new RoachPal("Roach5", "r5@gmail.com");

        // Creating our different list of amenities...
        ArrayList <String> amenities1 = new ArrayList<>();
        amenities1.add("foodbar");
        amenities1.add("spa");
        amenities1.add("autorefillbar");
        amenities1.add("shower");

        ArrayList <String> amenities2 = new ArrayList<>();
        amenities2.add("spa");
        amenities2.add("autorefillbar");
        amenities2.add("shower");

        ArrayList <String> amenities3 = new ArrayList<>();
        amenities3.add("foodbar");

        ArrayList <String> noAmenities = new ArrayList<>();

        // Roach colonies checking into the rooms...
        Room rm1 = motel.checkIn(rc1, "Suite", amenities1);
        System.out.println(motel);
        Room rm2 = motel.checkIn(rc2, "Deluxe", amenities2);
        Room rm3 = motel.checkIn(rc3, "Regular", amenities3);
        Room rm4 = motel.checkIn(rc4, "Regular", amenities2);
        Room rm5 = motel.checkIn(rc5, "Suite", noAmenities);
        System.out.println(motel);
        // We can see that we can't checkout a room if there's no space or the guest already checked one out
        motel.checkIn(rc6, "Regular", amenities3);
        motel.checkIn(rc2, "Deluxe", amenities2);
        System.out.println();

        // Party with anti shower in room
        System.out.println(rc1);
        rc1.party(motel.getOccupiedRooms());
        System.out.println(rc1 + "\n");

        // Party with no anti shower in room
        System.out.println(rc5);
        rc5.party(motel.getOccupiedRooms());
        System.out.println(rc5 + "\n");

        // We can also see that parties can only happen when colonies have rooms
        rc6.party(motel.getOccupiedRooms());
        System.out.println();

        // Now as the roaches check out, we can see that the rooms start to become vacant again
        motel.checkOut(rm1, 3, pay1);
        System.out.println();
        System.out.println(motel);

        motel.checkOut(rm2, 2, pay2);
        System.out.println();

        motel.checkOut(rm3, 1, pay3);
        System.out.println();

        motel.checkOut(rm4, 4, pay4);
        System.out.println();

        motel.checkOut(rm5, 7, pay5);
        System.out.println();
        System.out.println(motel);
    }
}
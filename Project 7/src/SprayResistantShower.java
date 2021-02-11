/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a SprayResistantShower. It will add on $25 to the total cost for each night the roaches
 * use this amenity.
 */
public class SprayResistantShower extends Amenities {
    /** Decorate our room with the amenity **/
    protected Room room;
    /** Cost of anti shower is $25 a night **/
    public static final double COST = 25;

    /**
     * Decorating room with the anti shower
     * @param r the room to decorate with
     */
    public SprayResistantShower(Room r){
        this.room = r;
    }

    /**
     * Add the amenity to the description of the room
     * @return the updated description
     */
    public String getDescription(){
        return room.getDescription() + ", shower";
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
    public double cost(){ return room.cost() + COST; }
}
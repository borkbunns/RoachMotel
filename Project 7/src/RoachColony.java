/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a RoachColony with a name, population, and growth rate.
 * It calculates the population of the roaches each time they party.
 */
import java.util.ArrayList;
public class RoachColony {
    /** The name of the roach colony **/
    private String name;
    /** The amount of roaches in the colony **/
    private int population;
    /** The growth rate of the colony when they party **/
    private double growthRate;

    /**
     * Constructor for the roach colony
     * @param n the name of the colony
     * @param pop the amount of roaches
     * @param gR the rate of growth
     */
    public RoachColony(String n, int pop, double gR){
        name = n;
        population = pop;
        growthRate = gR;
    }

    /**
     * The roach colonies will increase their population by their growth rate, and will be sprayed with insecticide,
     * losing 25% or 50% of their population depending if they have anti spray shower in their room
     * @param occupiedRooms this parameter value will be used to check that a colony is having a party in a owned room
     */
    public void party(ArrayList<Room> occupiedRooms) {
        for (Room room : occupiedRooms) {
            if (room.getColony() == this) {
                System.out.println(name + " is having a party in #" + room.getRoomNumber());
                this.population += this.population * this.growthRate;
                if (room.getDescription().contains("shower")) {
                    System.out.println("Anti spray shower available!");
                    this.population -= this.population * 0.25;
                } else {
                    System.out.println("Anti spray shower unavailable!");
                    this.population -= this.population * 0.5;
                }
                System.out.println("Spraying insecticide...");
                // End method after roaches finish partying
                return;
            }
        }
        // If the loop breaks, we can assume that the roach that is trying to party doesn't have a room to party in
        System.out.println(name + " is trying to have a party but doesn't have a room!");
    }

    /**
     * Getter for name
     * @return the name of the colony
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the population
     * @return the amount of roaches in the colony
     */
    public int getPopulation(){
        return population;
    }

    /**
     * Getter for the growth rate
     * @return the rate of growth of the colony
     */
    public double getGrowthRate(){
        return growthRate;
    }

    /**
     * String representation of RoachColony
     * @return the name of the colony as well as its population
     */
    @Override
    public String toString(){
        return name + " now has a population of : " + population;
    }
}
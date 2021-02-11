/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents RoachPal, which a form of payment. It can display a receipt whenever the roaches pay
 * their bill.
 */
public class RoachPal implements PaymentStrategy {
    /** A RoachPal requires only a name and email **/
    private String name, email;

    /**
     * Constructor for a RoachPal
     * @param name the name
     * @param email the email
     */
    public RoachPal(String name, String email){
        this.name = name;
        this.email = email;
    }

    /**
     * Display payment message with amount paid
     * @param amount the amount that was paid with RoachPal
     */
    public void pay(double amount){
        System.out.println(amount + " PAID WITH ROACHPAL - " + email);
    }
}
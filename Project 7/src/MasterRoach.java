/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class represents a MasterRoach, which is a form of payment the roaches can use for their bill.
 * Once they pay, a payment message will be displayed.
 */
public class MasterRoach implements PaymentStrategy {
    /** A MasterRoach card requires name, email, CVC, and expiration date**/
    private String name, email, securityCode, expiration;

    /**
     * Constructor for MasterRoach card
     * @param name the name
     * @param email the email
     * @param securityCode the cvc
     * @param expiration the expiration date
     */
    public MasterRoach(String name, String email, String securityCode, String expiration) {
        this.name = name;
        this.email = email;
        this.securityCode = securityCode;
        this.expiration = expiration;
    }

    /**
     * Display payment message with amount paid
     * @param amount the amount that was paid with MasterRoach
     */
    public void pay(double amount) {
        System.out.println(amount + " PAID WITH MASTERROACH - " + email);
    }
}
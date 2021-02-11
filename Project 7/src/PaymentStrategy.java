/**
 * Name: Alexander Pham, Peter Vu, Cindie Le
 * Date: 5/7/2020
 * Purpose: This class forces all classes that implement it to have a pay method.
 */
public interface PaymentStrategy {
    /**
     * The transaction of a payment will be processed by the type it is called on
     * @param amount the amount to pay
     */
    public void pay(double amount);
}
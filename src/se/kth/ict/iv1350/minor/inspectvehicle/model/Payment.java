package se.kth.ict.iv1350.minor.inspectvehicle.model;

import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.iv1350.payauth.CreditCard;

/**
 * The payment for a inspection.
 * @author mikaelnorberg
 */
public class Payment {
    private final CreditCardPayment creditCardPayment;

    /**
     * Creates a new instance.
     * @param creditCard The credit card that paid.
     * @param paidAmount The paid amount.
     */
    public Payment(CreditCard creditCard, Amount paidAmount) {
        this.creditCardPayment = new CreditCardPayment(creditCard, paidAmount);
    }

    /**
     * @return the creditCardPayment
     */
    public CreditCardPayment getCreditCardPayment() {
        return creditCardPayment;
    }
    
}

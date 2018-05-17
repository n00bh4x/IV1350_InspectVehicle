package se.kth.ict.iv1350.minor.inspectvehicle.model;

import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.iv1350.payauth.CreditCard;

/**
 * Represents a credit card payment.
 * @author mikaelnorberg
 */
class CreditCardPayment {
    private final CreditCard creditCard;
    private final Amount paidAmount;

    /**
     * Creates a new instance.
     * @param creditCard The credit card used to make the payment.
     * @param paidAmount The amount paid.
     */
    CreditCardPayment(CreditCard creditCard, Amount paidAmount) {
        this.creditCard = creditCard;
        this.paidAmount = paidAmount;
    }

    /**
     * @return the creditCard
     */
    CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * @return the paidAmount
     */
    public Amount getPaidAmount() {
        return paidAmount;
    }
    
}

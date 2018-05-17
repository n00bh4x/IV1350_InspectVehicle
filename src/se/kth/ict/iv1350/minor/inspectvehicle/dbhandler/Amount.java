package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

/**
 * This class is a disguise for the primitive type it holds.
 * @author mikaelnorberg
 */
public final class Amount {
    private final int amount;
    
    /**
     * Creates a new instance.
     * @param amount Represents an AMOUNT of something.
     */
    public Amount(final int amount) {
        this.amount = amount;
    }
    
    
    /**
     * @return the AMOUNT
     */
    public int getAmount() {
        return this.amount;
    }
    
    /**
     * Adds two amounts.
     * @param other one AMOUNT to be added to another AMOUNT.
     * @return the sum of two amounts.
     */
    public Amount plus(final Amount other) {
        return new Amount(this.amount + other.amount);
    }
    
    /**
     * Creates a string of the amount.
     * @return A string 
     */
    @Override
    public String toString() {
        return Integer.toString(this.amount);
    }
    
    /**
     * Compares two Amount objects.
     * @param object amount to compare with this instance.
     * @return true if equal.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Amount) {
            Amount otherAmount = (Amount)object;
            return (this.amount == otherAmount.getAmount());
        }
        return false;
    }

    /**
     * Returns a hash code of the object.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.amount;
        return hash;
    }
}

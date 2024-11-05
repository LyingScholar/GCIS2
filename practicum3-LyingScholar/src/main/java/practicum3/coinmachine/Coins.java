package practicum3.coinmachine;

/**
 * Enumeration representing common U.S. coin denominations in cents.
 */
public enum Coins {
    QUARTER(0.25), DIME(0.10), NICKEL(0.05),PENNY(0.01);

    //I'm not american, 
    //I have no idea what your currencies are, sorry if these are wrong
    //I just remember these from what we did in class
    
    /**
     * The value (in dollars) of the denomination.
     */
    private final double value;

    /**
     * Creates a denomination with the specified value.
     * 
     * @param value The value for this denomination.
     */
    private Coins(double value) {
        this.value = value;
    }

    /**
     * returns the value of the denomination.
     * 
     * @return The value of the denomination.
     */
    public double getValue() {
        return value;
    }
}

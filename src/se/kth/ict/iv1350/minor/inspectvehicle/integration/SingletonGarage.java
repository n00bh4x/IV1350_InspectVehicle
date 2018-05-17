package se.kth.ict.iv1350.minor.inspectvehicle.integration;

import se.kth.iv1350.garage.Garage;

/**
 * Creates one instance of a Garage.
 * @author mikaelnorberg
 */
public class SingletonGarage {
    private final static SingletonGarage INSTANCE = new SingletonGarage();
    private final Garage garage = new Garage();
    
    private SingletonGarage() {
    }
    
    /**
     * 
     * @return the only instance of this singleton.
     */
    public static SingletonGarage getGarage() {
        return INSTANCE;
    }
    
    /**
     * opens garage door and shows the next number in the queue.
     */
    public void nextCustomer() {
        this.garage.nextCustomer();
    }
    
    /**
     * closes the garage door.
     */
    public void closeDoor() {
        this.garage.closeDoor();
    }
}

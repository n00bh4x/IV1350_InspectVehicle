package se.kth.ict.iv1350.minor.inspectvehicle.view;

import java.util.Date;
import java.util.Random;
import se.kth.ict.iv1350.minor.inspectvehicle.controller.Controller;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.
                                              IllegalLicenseNumberException;
import se.kth.iv1350.payauth.CreditCard;

/**
 * This class represents the interface to the user.
 * @author mikaelnorberg
 */
public class View {
    private final InspectionStatsView inspectionStatsView;
    private final Controller controller;
    private CreditCard creditCard;
    
    /**
     * Creates a new instance
     * @param controller The controller used for all system operations
     */
    public View(Controller controller) {
        this.inspectionStatsView = new InspectionStatsView();
        this.controller = controller;
    }
    
    /**
     * Simulates user input that generates calls to all
     * system operations.
     */
    public void sampleExecution() {
        startInspection("TWS254");
        startInspection("DOG999XXX");
        startInspection("DDR333");
    }
    
    
    private void startInspection(String licenseNumber) {
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("FORDONSBESIKTNING");
            this.controller.startInspection();
            this.controller.closeGarageDoor();
            searchInspection(licenseNumber);
            this.controller.addObserver(this.inspectionStatsView);
            createCreditCard();
            this.controller.pay(this.creditCard);
            getInspections();
            System.out.println("SLUT");
            System.out.println("-------------------------------------------------");
            System.out.println("\n");
        } catch (IllegalLicenseNumberException noInspection) {
            System.out.println(noInspection.getMessage());
        }
    }

    
    private void getInspections() {
        int inspectionNumber = 0;
        boolean moreInspections = true;
        
        while (moreInspections) {
            if (getInspectionItem(inspectionNumber) == null) {
                moreInspections = false;
            }
            inspectionNumber++;
        }
    }
    
    
    private String getInspectionItem(int inspectionNumber) {
        return this.controller.getInspectionInstructions(randomBoolean(),
                                                         inspectionNumber);
    }

    
    private Boolean randomBoolean() {
        Random randomNumber = new Random();
        return randomNumber.nextBoolean();
    }


    private void searchInspection(String licenseNumber)
                    throws IllegalLicenseNumberException {
            System.out.println("Pris för besiktningen: " + 
               this.controller.searchInspection(licenseNumber) + " kr");
    }
    
    
    private void createCreditCard() {
        final Date date = new Date(2017, 11, 23);
        this.creditCard = new CreditCard(1234,"5384 2020 4951 4910",
                                         "John Appleseed", date, 856);
    }

}

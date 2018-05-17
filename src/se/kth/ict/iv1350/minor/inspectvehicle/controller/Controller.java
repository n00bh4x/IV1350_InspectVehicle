package se.kth.ict.iv1350.minor.inspectvehicle.controller;

import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.
                                              IllegalLicenseNumberException;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.
                                              InspectionResultRegistry;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.RegistryCreator;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.VehicleInspectionDTO;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.VehicleRegistry;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.Printer;
import se.kth.ict.iv1350.minor.inspectvehicle.model.Inspection;
import se.kth.ict.iv1350.minor.inspectvehicle.model.Payment;
import se.kth.ict.iv1350.minor.inspectvehicle.view.InspectionStatsView;
//import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.payauth.CreditCard;
import se.kth.iv1350.payauth.PaymentAuthorization;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.SingletonGarage;

/**
 * The controller handles all calls to the model.
 */
public class Controller {
    //private final Garage garage;
    private final VehicleRegistry vehicleRegistry;
    private final InspectionResultRegistry inspectionResultRegistry;
    private Inspection inspection;
    private final PaymentAuthorization paymentAuthorization;
    private final Printer printer;
    
    /**
     * Creates a new instance.
     * @param registryCreator Has references to the result registry and the
     * vehicle registry.
     * @param printer interface to the printer
     */
    public Controller(RegistryCreator registryCreator, Printer printer) {
        //this.garage = new Garage();
        this.vehicleRegistry = registryCreator.getVehicleRegistry();
        this.inspectionResultRegistry = registryCreator.
                                        getInspectionResultRegistry();
        this.printer = printer;
        this.paymentAuthorization = new PaymentAuthorization();
    }
    
    
    /**
     * Opens the garage door and shows the current queue number on the display.
     */
    public void startInspection() {
        SingletonGarage.getGarage().nextCustomer();
        //this.garage.nextCustomer();
    }
    
    
    /**
     * Closes the garage door.
     */
    public void closeGarageDoor() {
        SingletonGarage.getGarage().closeDoor();
        //this.garage.closeDoor();
    }

    /**
     * Searches for an inspection manual and creates a new inspection
     * if found.
     * @param licenseNumber The identifier for the search vehicle.
     * @return The cost for the inspection. null if no inspection was found.
     * @throws IllegalLicenseNumberException when there is no inspection for the
     * searched license number.
     */
    public Amount searchInspection(String licenseNumber)
                    throws IllegalLicenseNumberException {
        newInspection(findInspection(licenseNumber));
        return inspectionPrice();
    }

    /**
     * Handles the payment and prints receipt for a inspection.
     * @param creditCard Credit card information.
     */
    public void pay(CreditCard creditCard) {
        authorizePayment(creditCard);
        final Payment payment = new Payment(creditCard, inspectionPrice());
        this.inspection.setPayment(payment);
        printReceipt();
    }

    /**
     * Stores the inspection result in the database and prints the result of
     * the inspection.
     * @param inspectionResult Result for the performed inspection step.
     * @param inspectionNumber The place of the inspection in the list.
     * @return The next part to be inspected. Null if no more inspections.
     * @throws IndexOutOfBoundsException When no more inspections are available.
     */
    public String getInspectionInstructions(Boolean inspectionResult,
                                            int inspectionNumber)
                                            throws IndexOutOfBoundsException {
        try {
             String inspectedItem = this.inspection.getVehicleInspection().
                                  getInstructionItem(inspectionNumber);
             this.inspection.addResult(inspectedItem, inspectionResult);
             return inspectedItem;
            
        } catch (IndexOutOfBoundsException indexOutOfBounds) {
            this.inspectionResultRegistry.
                    storeInspection(this.inspection.getInspectionResult());
            this.inspection.printResult(this.printer);
            return null;
        }
    }

    
    private Boolean authorizePayment(CreditCard creditCard) {
        return this.paymentAuthorization.authorizePayment(creditCard,
                                    inspectionPrice().getAmount());
    }

    
    private Amount inspectionPrice() {
        return this.inspection.getInspectionPrice();
    }

    
    private void newInspection(VehicleInspectionDTO inspection) {
        this.inspection = new Inspection(inspection);
    }

    
    private void printReceipt() {
        this.inspection.printReceipt(this.printer);
    }


    private VehicleInspectionDTO findInspection(String licenseNumber)
                                    throws IllegalLicenseNumberException {
        return this.vehicleRegistry.searchInspection(licenseNumber);
    }

    public void addObserver(InspectionStatsView inspectionStatsView) {
        this.inspection.setObserver(inspectionStatsView);
    }
}

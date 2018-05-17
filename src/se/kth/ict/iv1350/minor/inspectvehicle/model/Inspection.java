package se.kth.ict.iv1350.minor.inspectvehicle.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.VehicleInspectionDTO;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.Printer;

/**
 * Represents a vehicleInspection.
 * @author mikaelnorberg
 */
public class Inspection {
    private final VehicleInspectionDTO vehicleInspection;
    private final List<InspectionResult> inspectionResult;
    private final Amount inspectionPrice;
    private Payment payment;
    private Observer observer;
    
    
    /**
     * Creates a new instance.
     * @param vehicleInspection Information about what to inspect on vehicle.
     */
    public Inspection(VehicleInspectionDTO vehicleInspection) {
        this.vehicleInspection = vehicleInspection;
        this.inspectionResult = new ArrayList<>();
        this.inspectionPrice  = new Amount(calculatePrice());
    }

    
    /**
     * Prints the receipt for the paid vehicleInspection
     * @param printer Interface to printer.
     */
    public void printReceipt(Printer printer) {
        Receipt receipt = new Receipt(this);
        print(printer, receipt.createReceiptString());
    }
    
    
    /**
     * Prints the result for the inspected vehicle.
     * @param printer Interface to the printer.
     */
    public void printResult(Printer printer) {
        for (InspectionResult inspectionResults : this.inspectionResult) {
            print(printer, inspectionResults.toString());
        }
    }

    /**
     * @return the vehicleInspection
     */
    public VehicleInspectionDTO getVehicleInspection() {
        return vehicleInspection;
    }
    
    
    /**
     * @return the inspectionPrice
     */
    public Amount getInspectionPrice() {
        return inspectionPrice;
    }   

    /**
     * @param payment 
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    /**
     * Add a result of a part of an vehicleInspection.
     * @param inspectedItem The inspected part of the vehicle.
     * @param result The result of the inspected part. Pass or fail.
     */
    public void addResult(String inspectedItem, boolean result) {
        notifyObserver(result);
        this.inspectionResult.add(new InspectionResult(inspectedItem, result));
    }

    /**
     * @return the inspectionResult
     */
    public List<InspectionResult> getInspectionResult() {
        return inspectionResult;
    }


    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }    
    
    /**
     * Registers an observer that shall be notified about the result of
     * a inspection.
     * @param observer the observer that shall be registered.
     */
    public void setObserver(Observer observer) {
        this.observer = observer;
    }
    
    
    
    private int calculatePrice() {
        Amount price = new Amount(0);
        final int sizeOfInspectionList = this.vehicleInspection.
                                        getInspectionInstructions().size();

        for (int index = 0; index < sizeOfInspectionList; index++) {
            price = price.plus(this.vehicleInspection.
                               getInstructionPrice(index));
        }
        return price.getAmount();
    }

    
    private void print(Printer printer, String document) {
        printer.print(document);
    }
    
    private void notifyObserver(boolean result) {
        observer.notify(result);
    }
}

package se.kth.ict.iv1350.minor.inspectvehicle.model;

import java.util.Date;

/**
 * This class represents a receipt of a <code>Inspection</code> object.
 * @author mikaelnorberg
 */
class Receipt {
    private final Inspection inspection;
    
    /**
     * Creates a new instance.
     * @param inspection Proof of payment for the paid<code>Inspection</code>.
     */
    Receipt(Inspection inspection) {
        this.inspection = inspection;
        
    }
    
    /**
     * Creates a formated text string that represents a receipt.
     * @return The formatted receipt.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        
        appendLine(builder, "------------------------------------------------");
        appendLine(builder, "KVITTO");
        
        appendLine(builder, "Bilbesiktning");
        endSection(builder);

        Date inspectionTime = new Date();        
        builder.append("Tid: ");
        appendLine(builder, inspectionTime.toString());

        builder.append("Besiktigat fordons registreringsnummer: ");
        appendLine(builder, this.inspection.getVehicleInspection()
                                           .getLicenseNumber());
        
        builder.append("Pris: ");
        appendLine(builder, inspection.getPayment().getCreditCardPayment().
                                       getPaidAmount().toString() + " kr");
        
        builder.append("Kreditkortsnummer: ");
        appendLine(builder, this.inspection.getPayment().getCreditCardPayment().
                                            getCreditCard().getNumber());
        
        appendLine(builder, "------------------------------------------------");
        
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        endSection(builder);
    }
    private void endSection(StringBuilder builder) { 
        builder.append("\n");
    }
}

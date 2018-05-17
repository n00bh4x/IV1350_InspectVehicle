package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

/**
 * This class specifies one single part to inspect of an inspection. 
 * @author mikaelnorberg
 */
final class InspectionInstructionDTO {
    private final String inspectionItem;
    private final Amount price;
    
    /**
     * Creates a new instance that represents one part of an inspection.
     * @param instructionItem Specifies what to inspect on vehicle.
     * @param price The price of the inspection on the specified item.
     */
    InspectionInstructionDTO(String instructionItem, int price) {
        this.inspectionItem = instructionItem;
        this.price = new Amount(price);
    }

    /**
     * @return the inspectionItem
     */
    String getInspectionItem() {
        return inspectionItem;
    }

    /**
     * @return the price
     */
    Amount getPrice() {
        return price;
    }
    
    
    /**
     * A text string explaining the inspection item.
     * @return readable text string.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Besiktningsdel: ").append(inspectionItem).append(", ");
        builder.append("Pris: ").append(price.toString()).append(" kr\n");
        return builder.toString();
    }

}

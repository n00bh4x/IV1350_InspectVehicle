package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import java.util.List;

/**
 * This class represents a inspection on a vehicle.
 * @author mikaelnorberg
 */
public final class VehicleInspectionDTO {
    private final List<InspectionInstructionDTO> inspectionInstructions;
    private final String licenseNumber;
    
    
    /**
     * Creates a new instance.
     * @param licenseNumber Identifier for the inspection.
     * @param inspectionInstructions Parts to inspect on vehicle when inspected.
     */
    VehicleInspectionDTO(String licenseNumber,
                        List<InspectionInstructionDTO> inspectionInstructions) {
        this.licenseNumber = licenseNumber;
        this.inspectionInstructions = inspectionInstructions;
    }


    /**
     * @return the inspectionInstructions list
     */
    public List<InspectionInstructionDTO> getInspectionInstructions() {
        return this.inspectionInstructions;
    }

    /**
     * @param index The position of the element in the list.
     * @return The element at position index of the list.
     */
    public InspectionInstructionDTO getInspectionInstruction(int index) {
        return this.getInspectionInstructions().get(index);
    }

    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return this.licenseNumber;
    }
    
    /**
     * 
     * @param index The place of the element in the list.
     * @return The price for one part of an inspection
     */
    public Amount getInstructionPrice(int index) {
        return this.getInspectionInstruction(index).getPrice();
    }
    
    /**
     * 
     * @param index The place for the element in the list.
     * @return A part of an inspection.
     */
    public String getInstructionItem(int index) {
        return this.getInspectionInstruction(index).getInspectionItem();
    }
}

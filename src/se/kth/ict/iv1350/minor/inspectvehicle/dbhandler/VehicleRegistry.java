package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents a database with all available inspections.
 * @author mikaelnorberg
 */
public class VehicleRegistry {
    private final List<VehicleInspectionDTO> vehicleInspections;
    
    /**
     * Creates a new instance.
     */
    VehicleRegistry() {
        vehicleInspections = new ArrayList<>();
        addInspections("TWS254");
        addInspections("DOG999");
        addInspections("DDR333");
    }


    /**
     * @return the vehicleInspections
     */
    public List<VehicleInspectionDTO> getVehicleInspections() {
        return vehicleInspections;
    }

    /**
     * Searches for a inspection for a vehicle.
     * @param licenseNumber The identifier for the searched vehicle.
     * @return Found inspection.
     * @throws IllegalLicenseNumberException when there is no inspection for the
     * searched license number.
     */
    public VehicleInspectionDTO searchInspection(String licenseNumber) 
                                throws IllegalLicenseNumberException {
        for (VehicleInspectionDTO inspection : vehicleInspections) {
            if (matches(inspection, licenseNumber)) {
                return inspection;
            }
        }
        throw new IllegalLicenseNumberException(licenseNumber);
    }
    
    private boolean matches(VehicleInspectionDTO inspection,
                            String licenseNumber) {
        return inspection.getLicenseNumber().equalsIgnoreCase(licenseNumber);
    }    
        
    
    private void addInspections(String licenseNumber) {
        this.getVehicleInspections().add(new VehicleInspectionDTO(licenseNumber,
                                             generateInspectionInstructions()));
    }

    private List<InspectionInstructionDTO> generateInspectionInstructions() {
        final List<InspectionInstructionDTO> inspInstr = new ArrayList<>();

        switch (generateRandomNumber()) {
            case 0: 
                inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
                inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
                inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
                break;
            
            case 1: 
                inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
                inspInstr.add(new InspectionInstructionDTO("Fläkt", 475));
                inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
                inspInstr.add(new InspectionInstructionDTO("Ljusbild", 39));
                break;
            
            default:
                inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
                inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
                inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
                inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
                inspInstr.add(new InspectionInstructionDTO("Rost", 25));
                break;
        }
        return inspInstr;
    }
    
    private int generateRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(3) + 5;
    }

}

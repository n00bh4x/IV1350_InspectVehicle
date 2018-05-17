package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

/**
 * Creates the "Databases" vehicle Registry and inspection result registry.
 * @author mikaelnorberg
 */
public final class RegistryCreator {
    private final VehicleRegistry vehicleRegistry;
    private final InspectionResultRegistry inspectionResultRegistry;
    
    /**
     * Creates a new instance.
     */
    public RegistryCreator() {
        this.vehicleRegistry = new VehicleRegistry();
        this.inspectionResultRegistry = new InspectionResultRegistry();
    }

    /**
     * @return the vehicleRegistry
     */
    public VehicleRegistry getVehicleRegistry() {
        return vehicleRegistry;
    }

    /**
     * @return the inspectionResultRegistry
     */
    public InspectionResultRegistry getInspectionResultRegistry() {
        return this.inspectionResultRegistry;
    }
}

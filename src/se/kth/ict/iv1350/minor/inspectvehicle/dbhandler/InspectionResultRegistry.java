package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.iv1350.minor.inspectvehicle.model.InspectionResult;

/**
 * A "database" holding all inspection results.
 * @author mikaelnorberg
 */
public final class InspectionResultRegistry {
    private final List<List<InspectionResult>> inspectionResults;
    
    
    /**
     * Creates a new instance.
     */
    public InspectionResultRegistry() {
        inspectionResults = new ArrayList<>();
    }
    
    /**
     * Stores a result of a inspection.
     * @param inspectionResult The result of a completed inspection.
     */
    public void storeInspection(List<InspectionResult> inspectionResult) {
        this.inspectionResults.add(inspectionResult);
    }
}

package se.kth.ict.iv1350.minor.inspectvehicle.model;

/**
 * The inspection result.
 * @author mikaelnorberg
 */
public class InspectionResult {
    private final String inspectedItem;
    private final boolean result;
    
    /**
     * Creates a new instance.
     * @param inspectedItem The inspected part of a inspection.
     * @param result The result of the inspected part. Pass or fail.
     */
    InspectionResult(String inspectedItem, boolean result) {
        this.inspectedItem = inspectedItem;
        this.result = result;
    }

    /**
     * Creates a text string for the result.
     * @return Formated text string.
     */
    @Override
    public String toString() {
        return "Besiktigad del: " + this.inspectedItem + 
               ", Resultat: " + booleanToString();
    }

    private String booleanToString() {
        if (this.result) {
            return "Godkänd";
        }
        return "Underkänd";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.view;

import se.kth.ict.iv1350.minor.inspectvehicle.model.Observer;

/**
 *
 * @author mikaelnorberg
 */
public class InspectionStatsView implements Observer {
    private int failedInspections = 0;
    private int passedInspections = 0;
    
    public void notify(boolean result) {
        if (result == true) {
            this.passedInspections++;
        } else {
            this.failedInspections++;
        }
        System.out.println("Passed: " + this.passedInspections + " Failed: "+
                this.failedInspections);
    }
}

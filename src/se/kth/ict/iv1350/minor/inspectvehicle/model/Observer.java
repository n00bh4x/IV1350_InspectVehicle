/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.model;

/**
 *This interface is used by objects that want to be notified about the result
 * of a inspection
 * @author mikaelnorberg
 */
public interface Observer {

    /**
     * Called when there is a new inspection result.
     * @param result the result of the inspection.
     */
    public void notify(boolean result);
    
}

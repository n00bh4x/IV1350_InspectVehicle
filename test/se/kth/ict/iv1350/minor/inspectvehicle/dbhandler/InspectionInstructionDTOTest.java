/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikaelnorberg
 */
public class InspectionInstructionDTOTest {
    
    public InspectionInstructionDTOTest() {
    }

    @Test
    public void testToStringNull() {
        InspectionInstructionDTO instance = new InspectionInstructionDTO(null, 9);
        String expResult = "Besiktningsdel: null, Pris: 9 kr\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringSuccess() {
        InspectionInstructionDTO instance = new InspectionInstructionDTO("Broms", 9);
        String expResult = "Besiktningsdel: Broms, Pris: 9 kr\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

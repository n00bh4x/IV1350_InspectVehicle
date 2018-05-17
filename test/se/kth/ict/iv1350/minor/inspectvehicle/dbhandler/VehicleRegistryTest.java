/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikaelnorberg
 */
public class VehicleRegistryTest {
    
    public VehicleRegistryTest() {
    }

    
    // För att testa måste man ändra parametern till searchInspection(0) till 0
    @Test (expected = NullPointerException.class)
    public void testSearchInspectionNotValidLicenseNumber() {
        String licenseNumber = "";
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        VehicleRegistry instance = new VehicleRegistry();
        
        String expLicenseNumberResult = null;
        String expInstructionItem = null;
        Amount expInstructionPrice = null;
        
        String licenseNumberResult = instance.searchInspection(licenseNumber).
                getLicenseNumber();
        String instructionItem = instance.searchInspection(licenseNumber).
                getInstructionItem(0);
        Amount instructionPrice = instance.searchInspection(licenseNumber).
                getInstructionPrice(0);
        
        assertEquals(expLicenseNumberResult, licenseNumberResult);
        assertEquals(expInstructionItem, instructionItem);
        assertEquals(expInstructionPrice, instructionPrice);
    }

    @Test
    public void testSearchInspectionValidLicenseNumber() {
        String licenseNumber = "TWS254";
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        VehicleRegistry instance = new VehicleRegistry();
        
        String expLicenseNumberResult = "TWS254";
        String expInstructionItem = "Bromsar";
        Amount expInstructionPrice = new Amount(995);
        
        String licenseNumberResult = instance.searchInspection(licenseNumber).
                getLicenseNumber();
        String instructionItem = instance.searchInspection(licenseNumber).
                getInstructionItem(0);
        Amount instructionPrice = instance.searchInspection(licenseNumber).
                getInstructionPrice(0);
        
        assertEquals(expLicenseNumberResult, licenseNumberResult);
        assertEquals(expInstructionItem, instructionItem);
        assertEquals(expInstructionPrice, instructionPrice);
    }
    
}

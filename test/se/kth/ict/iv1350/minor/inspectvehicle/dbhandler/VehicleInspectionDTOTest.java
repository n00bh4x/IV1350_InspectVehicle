/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mikaelnorberg
 */
public class VehicleInspectionDTOTest {
    
    public VehicleInspectionDTOTest() {
    }
    

    @Test
    public void testGetInspectionInstructionsFirstItem() {
        int index = 0;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expectedItemResult = "Bromsar";
        String itemResult = inspectionList.get(index).
                getInspectionInstructions().get(index).getInspectionItem();
        Amount expectedPriceResult = new Amount(995);
        Amount priceResult = inspectionList.get(index).
                getInspectionInstructions().get(index).getPrice();
        assertEquals(expectedItemResult, itemResult);
        assertEquals(expectedPriceResult, priceResult);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInspectionInstructionsOutOfBounds() {
        int index = 3;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expectedItemResult = null;
        String itemResult = inspectionList.get(index).
                getInspectionInstructions().get(index).getInspectionItem();
        Amount expectedPriceResult = null;
        Amount priceResult = inspectionList.get(index).
                getInspectionInstructions().get(index).getPrice();
        assertEquals(expectedItemResult, itemResult);
        assertEquals(expectedPriceResult, priceResult);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInspectionInstructionOutOfBounds() {
        int index = 3;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expResult = null;
        String result = inspectionList.get(index).getInstructionItem(index);
        assertEquals(expResult, result);
    }
    @Test 
    public void testGetInspectionInstruction() {
        int index = 0;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expResult = "Bromsar";
        String result = inspectionList.get(index).getInstructionItem(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLicenseNumberFirstItem() {
        int index = 0;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expResult = "TWS254";
        String result = inspectionList.get(index).getLicenseNumber();
        assertEquals(expResult, result);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetLicenseNumberIndexOutOfBounds() {
        int index = 3;
        List<VehicleInspectionDTO> inspectionList = new ArrayList<>();
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
        inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
        VehicleInspectionDTO inspection = new VehicleInspectionDTO("TWS254",
                inspInstr);
        inspectionList.add(inspection);
        String expResult = null;
        String result = inspectionList.get(index).getLicenseNumber();
        assertEquals(expResult, result);
    }    

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInstructionPriceIndexOutOfBounds() {
        int index = 5;
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
            inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
            inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
            inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
            inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
            inspInstr.add(new InspectionInstructionDTO("Rost", 25));
        Amount expResult = new Amount(995);
        Amount result = inspInstr.get(index).getPrice();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetInstructionPrice() {
        int index = 0;
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
            inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
            inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
            inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
            inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
            inspInstr.add(new InspectionInstructionDTO("Rost", 25));
        Amount expResult = new Amount(995);
        Amount result = inspInstr.get(index).getPrice();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetInstructionItemGetFirstItem() {
        String licenseNumber = "TWS254";
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
            inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
            inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
            inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
            inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
            inspInstr.add(new InspectionInstructionDTO("Rost", 25));
        int index = 0;
        VehicleInspectionDTO instance = new VehicleInspectionDTO(licenseNumber,
                                             inspInstr);
        String expResult = "Bromsar";
        String result = instance.getInstructionItem(index);
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testGetInstructionItemGetLastItem() {
        String licenseNumber = "TWS254";
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
            inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
            inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
            inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
            inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
            inspInstr.add(new InspectionInstructionDTO("Rost", 25));
        int index = 4;
        VehicleInspectionDTO instance = new VehicleInspectionDTO(licenseNumber,
                                             inspInstr);
        String expResult = "Rost";
        String result = instance.getInstructionItem(index);
        assertEquals(expResult, result); 
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInstructionItemOutOfBounds() {
        String licenseNumber = "TWS254";
        List<InspectionInstructionDTO> inspInstr = new ArrayList<>();
            inspInstr.add(new InspectionInstructionDTO("Bromsar", 995));
            inspInstr.add(new InspectionInstructionDTO("Stenskott", 95));
            inspInstr.add(new InspectionInstructionDTO("Avgasvärde", 595));
            inspInstr.add(new InspectionInstructionDTO("Motor", 9990));
            inspInstr.add(new InspectionInstructionDTO("Rost", 25));
        int index = 5;
        VehicleInspectionDTO instance = new VehicleInspectionDTO(licenseNumber,
                                             inspInstr);
        String expResult = "null";
        String result = instance.getInstructionItem(index);
        assertEquals(expResult, result); 
    }

    
}

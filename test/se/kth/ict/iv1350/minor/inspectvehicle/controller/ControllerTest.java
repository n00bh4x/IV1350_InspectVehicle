/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.controller;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.RegistryCreator;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.Printer;
import se.kth.iv1350.payauth.CreditCard;

/**
 *
 * @author mikaelnorberg
 */
public class ControllerTest {
    
    public ControllerTest() {
    }

    @Test
    public void testSearchInspectionNonValidLicenseNumber() {
        String licenseNumber = "TTTTTT";
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        Amount expResult = null;
        Amount result = controller.searchInspection(licenseNumber);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSearchInspectionValidLicenseNumber() {
        String licenseNumber = "TWS254";
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        Amount expResult = new Amount(11700);
        Amount result = controller.searchInspection(licenseNumber);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testPay() {
        Date date = new Date(2017, 10, 10);
        CreditCard creditCard = new CreditCard(222, "hej", "hej", date, 222);
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        controller.searchInspection("TWS254");
        controller.pay(creditCard);
    }
    
    
    @Test (expected = NullPointerException.class)
    public void testGetInspectionInstructionsOutOfBounds() {
        Boolean inspectionResult = true;
        int inspectionNumber = 5;
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        String expResult = null;
        String result = controller.getInspectionInstructions(inspectionResult,
                inspectionNumber);
        assertEquals(expResult, result);
    }
    

    @Test
    public void testGetInspectionInstructionsGetFirst() {
        Boolean inspectionResult = true;
        int inspectionNumber = 0;
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        controller.searchInspection("TWS254");
        String expResult = "Bromsar";
        String result = controller.getInspectionInstructions(inspectionResult,
                inspectionNumber);
        assertEquals(expResult, result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.model;

import java.util.Date;
import org.junit.Test;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.Amount;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.RegistryCreator;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.Printer;
import se.kth.iv1350.payauth.CreditCard;

/**
 *
 * @author mikaelnorberg
 */
public class InspectionTest {
    
    public InspectionTest() {
    }

    @Test
    public void testPrintReceipt() {
        Date date = new Date(2017, 10, 10);
        CreditCard creditCard = new CreditCard(222, "hej", "hej", date, 222);
        Amount amount = new Amount(0);
        Payment payment = new Payment(creditCard, amount);
        RegistryCreator creator = new RegistryCreator();
        Inspection instance = new Inspection(creator.getVehicleRegistry().
                getVehicleInspections().get(0));
        instance.setPayment(payment);
        Printer printer = new Printer();
        instance.printReceipt(printer);
    }
    
    
    @Test (expected = NullPointerException.class)
    public void testPrintReceiptNoPayment() {
        RegistryCreator creator = new RegistryCreator();
        Inspection instance = new Inspection(creator.getVehicleRegistry().
                getVehicleInspections().get(0));
        Printer printer = new Printer();
        instance.printReceipt(printer);
    }
    

    @Test
    public void testPrintResult() {
        RegistryCreator creator = new RegistryCreator();
        Inspection instance = new Inspection(creator.getVehicleRegistry().
                getVehicleInspections().get(0));
        Printer printer = new Printer();
        instance.printResult(printer);
    }
    
    
    @Test
    public void testAddResult() {
        RegistryCreator creator = new RegistryCreator();
        Inspection instance = new Inspection(creator.getVehicleRegistry().
                getVehicleInspections().get(0));
        instance.addResult(null, true);
        instance.addResult("TEST", true);
        instance.addResult("TEST", false);
    }
}

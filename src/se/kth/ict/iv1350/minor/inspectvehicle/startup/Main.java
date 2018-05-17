package se.kth.ict.iv1350.minor.inspectvehicle.startup;

import se.kth.ict.iv1350.minor.inspectvehicle.controller.Controller;
import se.kth.ict.iv1350.minor.inspectvehicle.dbhandler.RegistryCreator;
import se.kth.ict.iv1350.minor.inspectvehicle.integration.Printer;
import se.kth.ict.iv1350.minor.inspectvehicle.view.View;

/**
 * Responsible for the startup of the program.
 * @author mikaelnorberg
 */
public class Main {

    /**
     * Starts the application
     * 
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(registryCreator, printer);
        new View(controller).sampleExecution();
    }
}

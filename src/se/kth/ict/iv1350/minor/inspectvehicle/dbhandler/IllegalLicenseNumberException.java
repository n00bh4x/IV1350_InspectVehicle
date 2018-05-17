/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.minor.inspectvehicle.dbhandler;

/**
 *
 * @author mikaelnorberg
 */
public class IllegalLicenseNumberException extends Exception{
    private final String licenseNumber;

    IllegalLicenseNumberException(String licenseNumber) {
        super("Det finns inga tillgängliga besiktningar för fordonet med "
                + "registreringsnummer: " + licenseNumber);
        this.licenseNumber = licenseNumber;
    }
}

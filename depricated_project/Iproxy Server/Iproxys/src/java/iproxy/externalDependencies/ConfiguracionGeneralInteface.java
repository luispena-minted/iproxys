/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iproxy.externalDependencies;

/**
 *
 * @author root
 */

public interface ConfiguracionGeneralInteface {
    public static final double bit = 1; 
    public static final double Kilobit = 1024*bit;
    public static final double Megabit = 1024*Kilobit;

    public double getAnchoBanda();

    public void setAnchoBanda(double aAnchoBanda);

    public java.lang.String getPassword();

    public void setPassword(java.lang.String aPassword);
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;


import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.newton.lisaaKiihtyvyydet;

/**
 *
 * @author mka
 */
public class Ohjaaja {
    public static void main(String[] args) {
        Pallo lyontiPallo, mustaPallo;
        Pallot testiPallot;
        lisaaKiihtyvyydet testiLisays;
        
        lyontiPallo = new Pallo(1.0, 1.5, -5.0,-4.0, -3.0,-2.0, 0.16, -10,"valkoinen");
        mustaPallo = new Pallo(2.0, 0.5, -5.0,-4.0, -3.0,-2.0, 0.16, -10,"musta");
        testiPallot = new Pallot(lyontiPallo, mustaPallo);
        testiLisays = new lisaaKiihtyvyydet();
        
        testiPallot.nollaaKiihtyvyydet();
        testiLisays.lisaaCoulombKiihtyvyydetBiljardiPallot(testiPallot);
 

        // ohjelmakoodi
        System.out.println("Kokeillaan pääsemmekö metodimaailmaan:");
        
    }    
}

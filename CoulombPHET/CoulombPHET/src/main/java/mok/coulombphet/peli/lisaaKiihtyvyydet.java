/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;

/**
 * Pallojen keskinäisistä voimista aiheutuvat kiihtyvyydet
 * lisätään palloihin. 
 * kiihtyvyydet aiheutuvat:
 * 1) pallojen keskinäisistä coulombin voimista
 * (lisaaCoulombKiihtyvyydetBiljardiPallot)
 * 2) pallojen välisestä hard-core repulsiosta, joka estää pallojen
 * menemisen päällekkäin
 * (xxx funktio)
 * 3) kitkasta joka pysäyttää liikkeen
 * (xxx funktio)  
 */

public class lisaaKiihtyvyydet {

    public lisaaKiihtyvyydet() {
        // dummy
    }
   
    /**
     * Lisätään pallojen kiihtyvyyksiin
     * pallojen keskinäisistä Coulombin
     * voimista aiheutuvat kiihtyvyydet
     * ax = coulombsConstant * q1 * q2 * dx / (r² * mass)
     * ay = coulombsConstant * q1 * q2 * dy / (r² * mass)
     * yksiköt coulombi, metri, kilogramma
     * @param pallot Pallot jotka vuorovaikuttavat keskenään.
     */
    public void lisaaCoulombKiihtyvyydetBiljardiPallot(Pallot pallot) {
        double dx, dy, d2;
        final double coulombsConstant = 8.987551787368*1000000000;
        
        ArrayList<Pallo> p1 = pallot.getPallotArray();
        //System.out.println("OK1");
        //System.exit(1); 
        for (Pallo pallo1 : p1) {
            for (Pallo pallo2 : p1) {
                dx = pallo1.getPalloX() - pallo2.getPalloX();
                dy = pallo1.getPalloY() - pallo2.getPalloY();
                d2 = Math.sqrt(dx*dx + dy*dy);
                double varaus1 = pallo1.getPalloVaraus();
                double varaus2 = pallo2.getPalloVaraus();
                double massa1 = pallo1.getPalloMassa();
                // System.out.printf("%f %f %f \n", d2, varaus1, massa1);
                if (d2 > 0.01) {
                    pallo1.lisaaPalloAX(coulombsConstant *  
                        varaus1 * varaus2 * dx / (d2 * massa1));
                    pallo1.lisaaPalloAY(coulombsConstant *  
                        varaus1 * varaus2 * dy / (d2 * massa1));
                }
            }
        }
    }        
    

}

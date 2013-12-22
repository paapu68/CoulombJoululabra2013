/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.newton;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;

/**
 *
 * @author mka
 */
public class lisaaVoimat {
    
    // pallojen keskinäisistä voimista aiheutuvat kiihtyvyydet
    // lisätään palloihin. 
    // 2 argumenttia voi kuvata
    // a) lyöntipalloa (yhden pallon array) ja biljardipalloja
    // tai 
    // b) kaksi kertaa samoja biljardipalloja (p1 ja p2 ovat samat)
    // jolloin lasketaan biljardipallojen keskinäiset voimia.
   
    public void lisaaCoulombKiihtyvyydetBiljardiPallot(Pallot p1, Pallot p2) {
        // lisätään pallojen kiihtyvyyksiin
        // pellojen keskinäisistä coulombin
        // voimista aiheutuvat kiihtyvyydet
        // Tässä biljardipallot keskenään.
        double dx, dy, d2;
        final double coulombsConstant = 8.987551787368*1000000000;
        
        ArrayList<Pallo> pallot1 = p1.getPallot();
        ArrayList<Pallo> pallot2 = p2.getPallot();
        
        for (Pallo pallo1 : pallot1) {
            for (Pallo pallo2 : pallot2) {
                dx = pallo2.getPalloX() - pallo1.getPalloX();
                dy = pallo2.getPalloY() - pallo1.getPalloY();
                d2 = Math.sqrt(dx*dx + dy*dy);
                double varaus1 = pallo1.getPalloVaraus();
                double varaus2 = pallo2.getPalloVaraus();
                double massa1 = pallo1.getPalloMassa();
                if (d2 > 0.01) {
                    pallo1.lisaaPalloAX(coulombsConstant *  
                        varaus1 * varaus2 * dx / (d2 * massa1));
                    pallo1.lisaaPalloAY(coulombsConstant *  
                        varaus1 * varaus2 * dy / (d2 * massa1));
                    
                }
            }
        }
    }        
    
    public void lisaaCoulombKiihtLyontiBiljardiPallot(Pallo lyontiPallo, Pallot p2) {
        // lisätään pallojen kiihtyvyyksiin
        // pellojen keskinäisistä coulombin
        // voimista aiheutuvat kiihtyvyydet
        // Tässä lyöntipallon ja biljardipallojen coulomb vuorovaikutus
        double dx, dy, d2;
        final double coulombsConstant = 8.987551787368*1000000000;
        
        ArrayList<Pallo> pallot2 = p2.getPallot();
        double varaus1 = lyontiPallo.getPalloVaraus();
        double massa1 = lyontiPallo.getPalloMassa();
        for (Pallo pallo2 : pallot2) {
            dx = pallo2.getPalloX() - lyontiPallo.getPalloX();
            dy = pallo2.getPalloY() - lyontiPallo.getPalloY();
            d2 = Math.sqrt(dx*dx + dy*dy);
            
            double varaus2 = pallo2.getPalloVaraus();
            double massa2 = pallo2.getPalloMassa();
            pallo2.lisaaPalloAX(coulombsConstant *  
                 varaus1 * varaus2 * dx / (d2 * massa1));
            pallo2.lisaaPalloAY(coulombsConstant *  
                 varaus1 * varaus2 * dy / (d2 * massa1));
            lyontiPallo.lisaaPalloAX(-coulombsConstant *  
                 varaus1 * varaus2 * dx / (d2 * massa1));
            lyontiPallo.lisaaPalloAY(-coulombsConstant *  
                 varaus1 * varaus2 * dy / (d2 * massa1));
        }
    }        
}

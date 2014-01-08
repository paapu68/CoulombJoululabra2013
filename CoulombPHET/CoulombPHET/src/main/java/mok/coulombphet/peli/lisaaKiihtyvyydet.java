/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.LautaData;
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
    LautaData lautadata = new LautaData();
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
                double massa = lautadata.getPallonMassa();
                // System.out.printf("%f %f %f \n", d2, varaus1, massa1);
                if (d2 > 0.01) {
                    pallo1.lisaaPalloAX(coulombsConstant *  
                        varaus1 * varaus2 * dx / (d2 * massa));
                    pallo1.lisaaPalloAY(coulombsConstant *  
                        varaus1 * varaus2 * dy / (d2 * massa));
                }
            }
        }
    }        
    
    
       
    /**
     * Lisätään pallojen kiihtyvyyksiin
     * pallojen overlap vuorovaikutus.
     * Eli kun pallot meinaavat mennä päällekkäin sen estää
     * Lennard Jones repulsio
     * @see http://en.wikipedia.org/wiki/Lennard-Jones_potential
     * Tässä vain repulsiivine C12 termi.
     * @param pallot Pallot jotka vuorovaikuttavat keskenään.
     */
    public void lisaaHardCoreKiihtyvyydet(Pallot pallot) {
        double dx, dy, d, d10;
        final double epsilon = 1e-13;
        LautaData lautadata = new LautaData();
        final double minDist = lautadata.getPallonHalkaisija() /2.0;
        
        ArrayList<Pallo> p1 = pallot.getPallotArray();
        for (Pallo pallo1 : p1) {
            for (Pallo pallo2 : p1) {
                dx = pallo1.getPalloX() - pallo2.getPalloX();
                dy = pallo1.getPalloY() - pallo2.getPalloY();
                d = Math.sqrt(dx*dx + dy*dy) - minDist;
                d10 = Math.pow(d,10);
                double massa = lautadata.getPallonMassa();
                // System.out.printf("%f %f %f \n", d2, varaus1, massa1);
                if (pallo1 != pallo2) {
                    pallo1.lisaaPalloAX(
                    (epsilon * dx) / (d10 * massa));
                    pallo1.lisaaPalloAY( 
                    (epsilon * dy) / (d10 * massa));
                }
            }
        }
    }      
    
   /**
    * Lisätään kitkasta aiheuta hidastuvuus palloille.
    * Kitkan suunta on nopeutta vastaan.
    * @param pallot 
    * @see http://en.wikipedia.org/wiki/Friction#Dry_friction
    */
   public void lisaaKitka(Pallot pallot) {
        double vx, vy, massa, kitkaVoima;
        final double kitkaKerroin = 100.0;
        final double gravitaatioVakio = 9.81;
        LautaData lautadata = new LautaData();
        
        ArrayList<Pallo> p = pallot.getPallotArray();
        for (Pallo pallo : p) {
                vx = pallo.getPalloVX();
                vy = pallo.getPalloVY();
                massa = lautadata.getPallonMassa();
                kitkaVoima = kitkaKerroin * massa * gravitaatioVakio;
                pallo.lisaaPalloAX(-this.getYksikkoVektoriX(vx, vy)*
                        kitkaVoima/massa);            
                pallo.lisaaPalloAY(-this.getYksikkoVektoriY(vx, vy)*
                        kitkaVoima/massa);
        }
   }        

    /**
     * @param x vektorin x komponentti
     * @param y vektorin y komponentti
     * @return palautetaan xi+yi suuntaisen yksikkövektorin X komponentti 
     */   
    public double getYksikkoVektoriX(double x, double y){
        double d = Math.sqrt(x*x + y*y);
        if (d < 0.1){
            return 0.0;
        }
        else{
            return x/d;
        }
    }
    
    /**
     * @param x vektorin x komponentti
     * @param y vektorin y komponentti
     * @return palautetaan xi+yi suuntaisen yksikkövektorin Y komponentti 
     */
    public double getYksikkoVektoriY(double x, double y){
        double d = Math.sqrt(x*x + y*y);
        if (d < 0.1){
            return 0.0;
        }
        else{
            return y/d;
        }         
    }    
        
    
}

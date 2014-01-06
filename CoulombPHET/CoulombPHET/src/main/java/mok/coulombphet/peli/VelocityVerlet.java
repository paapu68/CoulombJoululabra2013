/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import java.util.ArrayList;
import java.util.Collections;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;

/**
 * Päivitetään pallojen paikat ja nopeudet
 * kiihtyvyydet saadaan voimista (a=F/m)
 * Aika kuluu hyppayksin dt (sekunteina).
 */
public class VelocityVerlet {
    private double dt;
    private double maxSiirtyma;
    
    public VelocityVerlet(double dt){
        this.dt = dt;
        this.maxSiirtyma = 1.0;
    }
    /**
     * Päivitetään pallojen paikat ja nopeudet
     * velocity-verlet algoritmin avulla
     * @see http://en.wikipedia.org/wiki/Verlet_integration
     * @param pallot näiden paikkoja ja nopeuksia muutetaan 
     */
    public void PaivitaVelocityVerlet(Pallot pallot) {
        
        
        double dx, dy, d2;
        double siirtyma;
        final double coulombsConstant = 8.987551787368*1000000000;        
        
        this.maxSiirtyma = -1.0;
        ArrayList<Pallo> p1 = pallot.getPallotArray();
        for (Pallo pallo1 : p1) {
            double axold = pallo1.getPalloAX();
            double ayold = pallo1.getPalloAY();
            double xold = pallo1.getPalloX();
            double yold = pallo1.getPalloY();
            
            double xnew = pallo1.getPalloX() + pallo1.getPalloVX()*dt
                    + 0.5 * pallo1.getPalloAX() * dt * dt;
            double ynew = pallo1.getPalloY() + pallo1.getPalloVY()*dt
                    + 0.5 * pallo1.getPalloAY() * dt * dt;
            pallo1.setPalloX(xnew);
            pallo1.setPalloY(ynew);
            double vxnew = pallo1.getPalloVX() 
                    + 0.5 * (axold + pallo1.getPalloAX()) * dt; 
            double vynew = pallo1.getPalloVY() 
                    + 0.5 * (ayold + pallo1.getPalloAY()) * dt;
            pallo1.setPalloVX(vxnew);
            pallo1.setPalloVY(vynew);
            siirtyma = Math.sqrt((xold-xnew)*(xold-xnew) 
                    + (yold-ynew)*(yold-ynew));
            if (siirtyma > this.maxSiirtyma){
                this.maxSiirtyma = siirtyma;
            }            
        }
    }
    
    /**
     * Palauttaa pallojen jonosta suurimman siirtymän, 
     * eli kuinka paljon pallo on maksimissaan liikkunut aika-askelten
     * välillä.
     * @return suurin pallon liikkuma matka
     */
    public double getMaxSiirtyma(){
        return this.maxSiirtyma;
    }
    
    public void setMaxSiirtyma(double x){
        this.maxSiirtyma = x;
    }    
    
    
}

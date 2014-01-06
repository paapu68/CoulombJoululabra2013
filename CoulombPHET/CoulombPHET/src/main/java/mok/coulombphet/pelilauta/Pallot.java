/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;
import java.util.ArrayList;    // imports ArrayList
/**
 * biljardipallojen jono ja jonoon liittyviä toimintoja.
 * Ensimmäisenä on lyöntipallo ja toisena musta pallo. 
 * Ne asetetaan konstruktorissa.
 */
public class Pallot {    
    private ArrayList<Pallo> pallot;  
    private double halkaisija;
    
    /** konstruktorissa asetetaan lyöntipallo jonon ensimmäiseksi ja 
        * musta pallo toiseksi.
        * @param halkaisija on pallojen halkaisija metreissä.
        */    
    public Pallot(Pallo lyontiPallo, Pallo mustaPallo, double halkaisija) {
    
        this.pallot = new ArrayList<Pallo>();
        if ("valkoinen" == lyontiPallo.getPalloVari()) { 
            this.pallot.add(lyontiPallo);
        }
        else {
            System.out.println("Pallot jonossa lyöntipallo on ensimmäinen");
            System.out.println("Sen värin pitää olla valkoinen");
            System.exit(1);            
        }
        if ("musta" == mustaPallo.getPalloVari()) { 
            this.pallot.add(mustaPallo);
        }
        else {
            System.out.println("Pallot jonossa musta pallo on toisena");
            System.out.println("Sen värin pitää olla musta");
            System.exit(1);            
        }
        this.halkaisija = halkaisija;
    }

    public ArrayList<Pallo> getPallotArray() {
        return this.pallot;
    }
    
    /** Annetaan pallojonon ensimmäinen pallo joka on valkoinen lyöntipallo
    * 
    */    
    public Pallo getLyontiPallo() {
        return this.getPallotArray().get(0);
    }
    
    /** Annetaan pallojonon toinen pallo joka on musta pallo
    * 
    */    
    public Pallo getMustaPallo() {
        return this.getPallotArray().get(1);
    }
    
    public double getHalkaisija() {
        return this.halkaisija;
    }
    
    /**
    * lisää pallo pallojonoon
    */
    public void lisaaPallo(Pallo pallo) {
        this.pallot.add(pallo);
    }
    
   /**
   * poista indexillä osoitettu pallo pallojonosta
   */ 
   public void poistaPallo(int killIndex) {
        this.pallot.remove(killIndex);
    }
    
   /**
   * nollataan pallojonon pallojen x ja y nopeudet
   */   
    public void nollaaNopeudet() {
        for (Pallo pallo : this.pallot) {
            pallo.setPalloVX(0.0);
            pallo.setPalloVY(0.0);
        }
    }
   
   /**
   * nollataan pallojonon pallojen x ja y kiihtyvyydet
   */   
    public void nollaaKiihtyvyydet() {
        for (Pallo pallo : this.pallot) {
            pallo.setPalloAX(0.0);
            pallo.setPalloAY(0.0);
        }
    }
    
   /**
   * palautetaan 
   * suurin nopeus
   * 
   */   
    public double suurinNopeus() {
        double v=0.0;
        double maxv=0.0;
        for (Pallo pallo : this.pallot) {
            v = Math.sqrt(pallo.getPalloVX()*pallo.getPalloVX()
                    +pallo.getPalloVY()*pallo.getPalloVY());
            if (maxv < v){
                maxv = v;
            }
        }
        return maxv;
    }   

    public double suurinKiihtyvyys() {
        double a=0.0;
        double maxa=0.0;
        for (Pallo pallo : this.pallot) {
            a = Math.sqrt(pallo.getPalloAX()*pallo.getPalloAX()
                    +pallo.getPalloAY()*pallo.getPalloAY());
            if (maxa < a){
                maxa = a;
            }
        }
        return maxa;
    }       
    
    /**
    * Arvotaan lyontipallolle uusi paikka
    * siten että se ei mene toisen pallon päälle.
    */
    public void arvoLyontiPallonPaikka(
            double minX, double minY, double maxX,  double maxY,
            double Dist) {
        Pallo lyontiPallo;
        lyontiPallo = this.pallot.get(0);
        double d, newx, newy;
        double minDist = 0.0;
        newx = 0.0;
        newy = 0.0;
        
        while (minDist < Dist){
            newx = minX + (Math.random() * (maxX - minX));
            newy = minY + (Math.random() * (maxY - minY));
            
            minDist = 100.0;      
            for (Pallo pallo : this.pallot.subList(1, this.pallot.size())) {
                d = Math.sqrt((newx - pallo.getPalloX())
                        *(newx - pallo.getPalloX())+
                        (newy - pallo.getPalloY())
                        *(newy - pallo.getPalloY()));
                if (d < minDist) {
                    minDist = d;
                }
            }

        }
        lyontiPallo.setPalloX(newx);
        lyontiPallo.setPalloY(newy);
        System.out.println("ARVOTTU:");
        System.out.println(newx);
        System.out.println(newy);
        System.out.println("---------");
    }
        
    /**
    * palautetaan vain värit
    */    
    @Override
    public String toString() {
        String message;
        message = "PALLOT (varit)";
        for ( Pallo pallo : this.pallot ) {
            message = message + " " + pallo.getPalloVari();
        }
        return message;
    }        
}

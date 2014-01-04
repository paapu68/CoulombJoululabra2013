/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;
import java.util.ArrayList;    // imports ArrayList
/**
 *
 * @author mka
 */
public class Pallot {
    // biljardipallojen jono
    // Ensimmäisenä on lyöntipallo ja toisena musta
    // pallo. Ne asetetaan konstruktorissa.
    // kulma johon lyöntipallon ammutaan on muutujassa 'kulma'
    
    private ArrayList<Pallo> pallot;  
    private double halkaisija;
    private double kulma;

    public Pallot(Pallo lyontiPallo, Pallo mustaPallo, double halkaisija) {
        // konstruktorissa asetetaan lyöntipallo jonon ensimmäiseksi ja 
        // musta pallo toiseksi.
        // pallot ovat samankokoisia, halkaisija on halkaisija
        this.kulma = 90.0;
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
    
    public double getHalkaisija() {
        return this.halkaisija;
    }
    
    public void lisaaPallo(Pallo pallo) {
        // lisää pallo pallojonoon
        this.pallot.add(pallo);
    }
    
   public void poistaPallo(int killIndex) {
        // lisää pallo pallojonoon
        this.pallot.remove(killIndex);
    }
    
    public void nollaaKiihtyvyydet() {
        // nollataan pallojen x ja y kiihtyvyydet        
        for (Pallo pallo : this.pallot) {
            pallo.setPalloAX(0.0);
            pallo.setPalloAY(0.0);
        }
    }
    
    public void arvoLyontiPallonPaikka(
            double minX, double maxX, double minY, double maxY,
            double Dist) {
        // Arvotaan lyontipallolle uusi paikka
        // siten että se ei mene toisen pallon päälle.
        Pallo lyontiPallo;
        lyontiPallo = this.pallot.get(0);
        double d = 0.0, newx, newy;
        double minDist = 0.0;
        
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
    }
    
    public void kierraVastapaivaan() {
        // lyontipallon lähtösuunta kierretään vastapaivaan
        this.kulma = this.kulma + 1.0;
        if (this.kulma > 360.0){
            this.kulma = this.kulma - 360.0;
        }
    }
    
    public void kierraMyotapaivaan() {
        // lyontipallon lähtösuunta kierretään myötäpäivään
        this.kulma = this.kulma - 1.0;
        if (this.kulma < 0.0){
            this.kulma = this.kulma + 360.0;
        }
    }
    
    
    @Override
    public String toString() {
        // palautetaan vain värit
        String message;
        message = "PALLOT (varit)";
        for ( Pallo pallo : this.pallot ) {
            message = message + " " + pallo.getPalloVari();
        }
        return message;
    }        
}

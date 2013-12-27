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
    
    private ArrayList<Pallo> pallot;  

    public Pallot(Pallo lyontiPallo, Pallo mustaPallo) {
        // konstruktorissa asetetaan lyöntipallo jonon ensimmäiseksi ja 
        // musta pallo toiseksi.
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
    }

    public ArrayList<Pallo> getPallot() {
        return this.pallot;
    }
    
    public void lisaaPallo(Pallo pallo) {
        // lisää pallo pallojonoon
        this.pallot.add(pallo);
    }
    
    public void nollaaKiihtyvyydet() {
        // nollataan pallojen x ja y kiihtyvyydet        
        for (Pallo pallo : this.pallot) {
            pallo.setPalloAX(0.0);
            pallo.setPalloAY(0.0);
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

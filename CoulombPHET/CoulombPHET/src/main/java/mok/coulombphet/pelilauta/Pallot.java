/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;
import java.util.ArrayList;    // imports ArrayList
/**
 * biljardipallojen jono ja jonoon liittyviä toimintoja.
 * Oletus: ensimmäisenä on lyöntipallo ja toisena musta pallo. 
 */
public class Pallot {    
    private ArrayList<Pallo> pallot;  
    private LautaData lautadata = new LautaData(); 
    /** 
     * Biljardipallojen jono 
     */    
    public Pallot() {
        this.pallot = new ArrayList<Pallo>();
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
    }
        
    /**
    * Asetetaan pallojen alkupaikat.
    *
    */
    public void asetaPallojenAlkupaikat(){
        double x, y;
        Pallo pallo;
        // valkoinen pallo ensin
        pallo = new Pallo(lautadata.valkoinenX, lautadata.valkoinenY);
        this.pallot.add(pallo);
        // musta pallo toiseksi
        pallo = new Pallo(lautadata.alkuX,lautadata.alkuY-2.0*lautadata.pallonHalkaisija);
        this.pallot.add(pallo);
        // kärkipallo
        pallo = new Pallo(lautadata.alkuX,lautadata.alkuY);
        this.pallot.add(pallo); 
        
        y = lautadata.alkuY;
        for (int row = 1; row <= 4 ; row = row + 1) {
            x = lautadata.alkuX 
                    - (row+1)*Math.sin(50.0/360.0*2.0*Math.PI)
                    *lautadata.pallonHalkaisija;
            y -= lautadata.pallonHalkaisija;
            for (int column = 0; column <= row ; column = column + 1) {
                x += lautadata.pallonHalkaisija*1.2;
                // ei laiteta mustaa palloa toiseen kertaan
                if (row == 2 && column ==1){
                   
                }
                else{
                     pallo = new Pallo(x,y);
                    this.pallot.add(pallo); 
                }
            }     
        }
    }
    
    /**
    * Asetetaan pallojen varit.
    * vain 0. ja 1. pallo, muut väri varauksen perusteella
    */
    public void asetaPallojenVarit(){       
        // valkoinen pallo ensin
        this.pallot.get(0).setPalloVari("valkoinen");
        // musta pallo toiseksi
        this.pallot.get(1).setPalloVari("musta");
                // negatiiviset (punaiset pallot, 2-8)
        for (int i = 2; i <= 8 ; i = i + 1) {
            this.pallot.get(i).setPalloVari("punainen");
        }
        // positiiviset (siniset pallot, 9-15)
        for (int i = 9; i <= 15 ; i = i + 1) {
            this.pallot.get(i).setPalloVari("sininen");
        }    
    }
    
    /**
    * Asetetaan pallojen varaukset.
    * pallot 2-8 negatiivisia
    * pallot 9-15 positiivisia
    */
    public void asetaPallojenVaraukset(int varaus){          
        // negatiiviset (punaiset pallot, 2-8)
        for (int i = 2; i <= 8 ; i = i + 1) {
            this.pallot.get(i).setPalloVaraus(-varaus);
        }
        // positiiviset (siniset pallot, 9-15)
        for (int i = 9; i <= 15 ; i = i + 1) {
            this.pallot.get(i).setPalloVaraus(varaus);
        }    
    }
    
    /**
    * palautetaan vain varaukset
    */    
    @Override
    public String toString() {
        String message;
        message = "PALLOT (varit)";
        for ( Pallo pallo : this.pallot ) {
            message = message + " " + pallo.getPalloVaraus();
        }
        return message;
    }        
}

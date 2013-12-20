/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

/**
 *
 * @author mka, copied from OHJA
 */
public class Pallo {
    // Sisältää pallon 2d paikan, 2d nopeuden, 2d kiihtyvyyden
    // massan varauksen ja värin
    // sekä metodit niiden asettamiseen ja antamiseen ulos
 
    private int x;
    private int y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double massa; 
    private int varaus;
    private String vari;

    public Pallo(int x, int y, double vx, double vy, double ax, double ay, 
            double massa, int varaus, String vari) {
        // xx tarkasta etta x, y 0..xx
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.massa = massa;
        this.varaus = varaus;
        this.vari = vari;
    }

    public int getPalloX(){
        // pallon x koordinaatti annetaan ulos
        return this.x;
    }
    
    public int getPalloY(){
        // pallon y koordinaatti annetaan ulos
        return this.y;
    }
    
    public double getPalloVX(){
        // pallon nopeuden x koordinaatti annetaan ulos
        return this.vx;
    }
    
    public double getPalloVY(){
        // pallon nopeuden y koordinaatti annetaan ulos
        return this.vy;
    }
    
    public double getPalloAX(){
        // pallon kiihtyvyyden x koordinaatti annetaan ulos
        return this.ax;
    }
    
    public double getPalloAY(){
        // pallon kiihtyvyyden y koordinaatti annetaan ulos
        return this.ay;
    }
    public void setPalloX(int x){
        // asetetaan pallon x koordinaatti 
        this.x = x;
    }
    
    public void setPalloY(int y){
        // asetetaan pallon y koordinaatti
            this.y= y;
    }
    
    public void setPalloVX(double vx){
        // asetetaan pallon nopeuden x koordinaatti 
        this.vx = vx;
    }
    
    public void setPalloVY(double vy){
        // asetetaan pallon nopeuden y koordinaatti 
        this.vy = vy;
    }
    
    public void setPalloAX(double ax){
        // asetetaan pallon kiihtyvyyden x koordinaatti 
        this.ax = ax;
    }
    
    public void setPalloAY(double ay){
        // asetetaan pallon kiihtyvyyden y koordinaatti 
        this.ay = ay;
    }
   public double getPalloMassa(){
        // pallon kiihtyvyyden y koordinaatti annetaan ulos
        return this.massa;
    }
    public void setPalloMassa(double massa){
        // asetetaan pallon massa
        this.massa = massa;
    }    
    public String getPalloVari(){
        // annetaan pallon väri ulos
        return this.vari;
    }
    
    public void setPalloVari(String vari){
        // asetetaan pallon väri
        this.vari = vari;
    }
    
    public int getPalloVaraus(){
        // annetaan ulos pallon coulombin varaus
        return this.varaus;
    }
    
    public void setPalloVaraus(int varaus){
        // asetetaan pallon coulombin varaus
        this.varaus = varaus;
    }    
    
    @Override
    public String toString() {
        return "PALLO x: "+this.x+",y: "+this.y+"  "+this.varaus+"  "+this.vari;
    }    
}    


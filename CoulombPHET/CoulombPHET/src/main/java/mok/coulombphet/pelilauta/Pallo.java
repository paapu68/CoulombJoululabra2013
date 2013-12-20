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
    private float vx;
    private float vy;
    private float ax;
    private float ay;
    private float massa; 
    private int varaus;
    private String vari;

    public Pallo(int x, int y, float vx, float vy, float ax, float ay, 
            float massa, int varaus, String vari) {
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
    
    public float getPalloVX(){
        // pallon nopeuden x koordinaatti annetaan ulos
        return this.vx;
    }
    
    public float getPalloVY(){
        // pallon nopeuden y koordinaatti annetaan ulos
        return this.vy;
    }
    
    public float getPalloAX(){
        // pallon kiihtyvyyden x koordinaatti annetaan ulos
        return this.ax;
    }
    
    public float getPalloAY(){
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
    
    public void setPalloVX(float vx){
        // asetetaan pallon nopeuden x koordinaatti 
        this.vx = vx;
    }
    
    public void setPalloVY(float vy){
        // asetetaan pallon nopeuden y koordinaatti 
        this.vy = vy;
    }
    
    public void setPalloAX(float ax){
        // asetetaan pallon kiihtyvyyden x koordinaatti 
        this.ax = ax;
    }
    
    public void setPalloAY(float ay){
        // asetetaan pallon kiihtyvyyden y koordinaatti 
        this.ay = ay;
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


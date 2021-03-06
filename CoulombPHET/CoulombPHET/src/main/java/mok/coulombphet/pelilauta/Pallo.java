/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

/**
 *  Sisältää pallon 2d paikan, 2d nopeuden, 2d kiihtyvyyden
 *  massan varauksen ja värin
 *  sekä metodit niiden asettamiseen ja antamiseen ulos
 *  Lyöntipallon väri on 'valkoinen' mustan pallon väri on 'musta'
 *  yksiköt m, , m/s, m/s², kg, mikro Coulomb
 * 
 */
public class Pallo {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double varaus;
    private String vari;

   /**
    *  @param x pallon x koordinaatti
    *  @param y pallon y koordinaatti
    *  vx pallon x suunnan vauhti
    *  vy pallon y suunnan vauhti
    *  ax pallon x suunnan kiihtyvyys
    *  ay pallon y suunnan kiihtyvyys
    *  varaus pallon varaus mikrocoulombeina
    *  vari pallon väri
    */
    public Pallo(double x, double y) {
        this.x = x;
        this.y = y;
        this.vx = 0.0;
        this.vy = 0.0;
        this.ax = 0.0;
        this.ay = 0.0;
        this.varaus = 0.0;
        this.vari = "";
    }

    public double getPalloX(){
        return this.x;
    }
    
    public double getPalloY(){
        return this.y;
    }
    
    public double getPalloVX(){
        return this.vx;
    }
    
    public double getPalloVY(){
        return this.vy;
    }
    
    public double getPalloAX(){
        return this.ax;
    }
    
    public double getPalloAY(){
        return this.ay;
    }
    
    public void setPalloX(double x){
        this.x = x;
    }
    
    public void setPalloY(double y){
            this.y= y;
    }
    
    public void setPalloVX(double vx){
        this.vx = vx;
    }
    
    public void setPalloVY(double vy){
        this.vy = vy;
    }
    
    public void setPalloAX(double ax){
        this.ax = ax;
    }
    
    public void setPalloAY(double ay){
        this.ay = ay;
    }
    
    /**
    * lisätään pallon kiihtyvyyden x koordinaattia 
    */    
    public void lisaaPalloAX(double ax){
        this.ax += ax;
    }
    
    /**
    * lisätään pallon kiihtyvyyden y koordinaattia 
    */
    public void lisaaPalloAY(double ay){
        this.ay += ay;
    }    
    
    public String getPalloVari(){
        return this.vari;
    }
    
    public void setPalloVari(String vari){
        this.vari = vari;
    }
    
    public double getPalloVaraus(){
        return this.varaus;
    }
    
    /**
    * asetetaan pallon coulombin varaus (mikrocoulombeissa)
    */
    public void setPalloVaraus(int varaus){        
        this.varaus = varaus * 0.000001;
    }    
    
    @Override
    public String toString() {
        return "PALLO x: "+this.x+",y: "+this.y+"  "+this.varaus+"  "+this.vari;
    }    
}    


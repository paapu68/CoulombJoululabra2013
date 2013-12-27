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
    // Lyöntipallon väri on 'valkoinen' mustan pallon väri on 'musta'
    // yksiköt m, , m/s, m/s², kg, mikro Coulomb
    // pallon paino on n. 0.160 kg
    // pelilauta n. 2.7m x 1.4 m
 
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double massa; 
    private double varaus;
    private String vari;

    public Pallo(double x, double y, double vx, double vy, double ax, double ay, 
            double massa, int varaus, String vari) {
        // xx tarkasta etta x, y 0..xx
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.massa = massa;
        this.varaus = varaus*0.000001;
        this.vari = vari;
    }

    public double getPalloX(){
        // pallon x koordinaatti annetaan ulos
        return this.x;
    }
    
    public double getPalloY(){
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
    
    public void setPalloX(double x){
        // asetetaan pallon x koordinaatti 
        this.x = x;
    }
    
    public void setPalloY(double y){
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
    
    public void lisaaPalloAX(double ax){
        // lisätään pallon kiihtyvyyden x koordinaattia 
        this.ax += ax;
    }
    
    public void lisaaPalloAY(double ay){
        // lisätääm pallon kiihtyvyyden y koordinaattia 
        this.ay += ay;
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
    
    public double getPalloVaraus(){
        // annetaan ulos pallon coulombin varaus (coulombeissa)
        return this.varaus;
    }
    
    public void setPalloVaraus(int varaus){
        // asetetaan pallon coulombin varaus (mikrocoulombeissa)
        this.varaus = varaus * 0.000001;
    }    
    
    @Override
    public String toString() {
        return "PALLO x: "+this.x+",y: "+this.y+"  "+this.varaus+"  "+this.vari;
    }    
}    


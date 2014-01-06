/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

/**
 * Toiminnot jotka liittyvät biljardipelin lyöntikeppiin.
 * Kepin piirtäminen on kuitenkin piirtoalusta luokassa.  
 * 
 */
public class Keppi {  
    private double kulma, kulmaAskel;
    private double poikkeama, poikkeamaAskel;
    private double jousivakio;
    private LautaData lautadata = new LautaData();    

    public Keppi(){
        this.kulma = 270.0;
        this.kulmaAskel = 1.0;
        this.poikkeama = 0.01;
        this.poikkeamaAskel = 0.01;
        //this.jousivakio = 10;
        this.jousivakio = 100000000;
    }
    
    public double getKulmaRadian(){
        return this.kulma/360.0*2.0*Math.PI;
    }
    
    public double getPoikkeama(){
        return this.poikkeama;
    }
    
    /**
     * voima newtoneissa jolla kepillä lyödään palloa
     * @return voima 
     */
    public double getVoima(){
        return -this.jousivakio*this.poikkeama;
    }
    
    /**
     * lyontipallon lähtösuunta kierretään vastapaivaan
     */
    public void kierraVastapaivaan() {        
        this.kulma = this.kulma + this.kulmaAskel;
        if (this.kulma > 360.0){
            this.kulma = this.kulma - 360.0;
        }
    }
    
     /**
     * lyontipallon lähtösuunta kierretään myötäpäivään
     */
    public void kierraMyotapaivaan() {
        this.kulma = this.kulma - this.kulmaAskel;
        if (this.kulma < 0.0){
            this.kulma = this.kulma + 360.0;
        }
    }
    
    /**
     *  lisätään lyöntivoimaa, jolla valkoista palloa lyödään
     */
    public void viritaKeppia(){

        if (this.poikkeama < lautadata.kepinPituus){
            this.poikkeama = this.poikkeama + this.poikkeamaAskel; 
        }
    }
    
   /**
     *  vähennetään lyöntivoimaa, jolla valkoista palloa lyödään
     */    
    public void puraKeppia(){
        if (this.poikkeama > this.poikkeamaAskel){
            this.poikkeama = this.poikkeama - this.poikkeamaAskel; 
        }
    }
    
    /**
     * Asetetaan pallolle kepin iskua vastaava lähtönopeus
     * @param pallo johon kepin isku kohdistuu
     */
    public void iske(Pallo pallo){
        // f=m*a = m*dv/dt
        // dv=f*dt/m
        pallo.setPalloVX(-lautadata.getDT()/pallo.getPalloMassa()*
                this.getVoima()*Math.cos(this.getKulmaRadian()));
        pallo.setPalloVY(-lautadata.getDT()/pallo.getPalloMassa()*
                this.getVoima()*Math.sin(this.getKulmaRadian()));
    }
    
    
    
}










/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

/**
 *
 * @author mka
 */
public class Keppi {
    // toiminnot jotka liittyvät biljardipelin lyöntikeppiin.
    // Kepin piirtäminen on kuitenkin piirtoalusta oliossa.    
    private double kulma, kulmaAskel;
    private double poikkeama, poikkeamaAskel;
    private double jousivakio;
    private LautaData lautadata = new LautaData();    

    public Keppi(){
        this.kulma = 270.0;
        this.kulmaAskel = 1.0;
        this.poikkeama = 0.0;
        this.poikkeamaAskel = 0.001;
        //this.jousivakio = 10;
        this.jousivakio = 10000000;
    }
    
    public double getKulmaRadian(){
        return this.kulma/360.0*2.0*Math.PI;
    }
    
    public double getPoikkeama(){
        return this.poikkeama;
    }
    
    public double getVoima(){
        // voima newtoneissa jolla kepillä lyödään palloa
        return -this.jousivakio*this.poikkeama;
    }
    
    public void kierraVastapaivaan() {
        // lyontipallon lähtösuunta kierretään vastapaivaan
        this.kulma = this.kulma + this.kulmaAskel;
        if (this.kulma > 360.0){
            this.kulma = this.kulma - 360.0;
        }
    }
    
    public void kierraMyotapaivaan() {
        // lyontipallon lähtösuunta kierretään myötäpäivään
        this.kulma = this.kulma - this.kulmaAskel;
        if (this.kulma < 0.0){
            this.kulma = this.kulma + 360.0;
        }
    }
    
    public void viritaKeppia(){
        // lisätään lyöntivoimaa
        // samalla keppi siirtyy kuvassa
        if (this.poikkeama < lautadata.kepinPituus){
            this.poikkeama = this.poikkeama + this.poikkeamaAskel; 
        }
    }
    
    public void puraKeppia(){
        // vähennetään lyöntivoimaa
        // samalla siirretään keppia kuvassa
        if (this.poikkeama > this.poikkeamaAskel){
            this.poikkeama = this.poikkeama - this.poikkeamaAskel; 
        }
    }
    
    public void iske(Pallo pallo){
        // f=m*a = m*dv/dt
        // dv=f*dt/m
        pallo.setPalloVX(lautadata.getDT()/pallo.getPalloMassa()*
                this.getVoima()*Math.cos(this.getKulmaRadian()));
        pallo.setPalloVY(-lautadata.getDT()/pallo.getPalloMassa()*
                this.getVoima()*Math.sin(this.getKulmaRadian()));
        //pallo.setPalloVX(100);
        //System.out.println(lautadata.getDT());
        //System.out.println(pallo.getPalloMassa());
        //System.out.println(this.getVoima());
        //System.out.println(Math.cos(this.getKulmaRadian()));
        //System.out.println(pallo.getPalloVX());
        //System.out.println(lautadata.getDT()*this.getVoima()*Math.cos(this.getKulmaRadian()));
        //System.exit(1);
    }
    
    
    
}










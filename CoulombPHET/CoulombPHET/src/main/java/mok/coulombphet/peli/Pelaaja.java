/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

/**
 * Sisältää pelaajaan liittyvät tiedot: pisteet, minkä värisiä palloja
 * yrittää, yrittääkö mustaa palloa, onko voittanut tai hävinnyt.
 *
 */
public class Pelaaja {
    private int pallojaJaljella;
    private String yritanVaria;
    private Boolean yritanMustaaPalloa;
    private Boolean voittanut;
    private Boolean havinnyt;
    
    public Pelaaja(){
        this.pallojaJaljella = 7;
        this.yritanVaria = "enTieda";
        this.yritanMustaaPalloa = false;
        this.voittanut = false;
        this.havinnyt = false;
    }
    
    public void vahennaPallojaJaljella(int lisays){
        this.pallojaJaljella -= this.pallojaJaljella;
    }
    
    public int getPallojaJaljella(){
        return this.pallojaJaljella;
    }
    
    public void setYritanVaria(String vari){
        if (vari.equals("punainen")){
            this.yritanVaria = vari;
        }
        if (vari.equals("sininen")){
            this.yritanVaria = vari;
        }
    }
    
    public String getYritanVaria(){
        return this.yritanVaria;
    }

    public void setYritanMustaaPalloa(Boolean yritanMustaa){
        this.yritanMustaaPalloa = yritanMustaa;
    }
    
    public Boolean getYritanMustaaPalloa(){
        return this.yritanMustaaPalloa;
    }    

    public void setHavinnyt(Boolean havinnyt){
        this.havinnyt = havinnyt;
    }
    
    public Boolean getHavinnyt(){
        return this.havinnyt;
    }      
    
    public void setVoittanut(Boolean voittanut){
        this.voittanut = voittanut;
    }
    
    public Boolean getvoittanut(){
        return this.voittanut;
    }          
    
}

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
    private int pisteet;
    private String yritanVaria;
    private Boolean yritanMustaaPalloa;
    private Boolean voittanut;
    private Boolean havinnyt;
    
    public Pelaaja(){
        this.pisteet = 0;
        this.yritanVaria = "enTieda";
        this.yritanMustaaPalloa = false;
        this.voittanut = false;
        this.havinnyt = false;
    }
    
    public void lisaaPisteet(int lisays){
        this.pisteet += this.pisteet;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    public void setYritanVaria(String vari){
        this.yritanVaria = vari;
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

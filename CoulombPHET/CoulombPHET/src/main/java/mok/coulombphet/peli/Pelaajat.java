/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.pelilauta.Reiat;

/**
 *
 * Pelaajien jono ja pelaajiin liittyvät toiminnot.
 */
public class Pelaajat {
    private ArrayList<Pelaaja> pelaajat;
    private int vuoro;
    
    public Pelaajat(){
        this.vuoro = 0;
        this.pelaajat = new ArrayList<Pelaaja>();
        Pelaaja pelaaja1 = new Pelaaja();
        pelaajat.add(pelaaja1);
        Pelaaja pelaaja2 = new Pelaaja();
        pelaajat.add(pelaaja2);
        
    }
    
    public void vaihdaVuoro(){
        if (this.vuoro == 0){
            this.vuoro = 1;
        }
        else {
            this.vuoro = 0;
        }
    }
    
    /**
     * jos yritetään punaisia palloja saa lyöntipallo 
     * negatiivisen varauksen
     * samoin kuin musta pallo
     * vastaavasti jos
     * yritetään sinisiä palloja saa lyöntipallo 
     * positiivisen varauksen
     * samoin kuin musta pallo
     * @param pallot 
     */
    public void vaihdaVaraukset(Pallot pallot){
        int varaus = pallot.getPallojenPerusVaraus();
        
        if (this.getPelaaja().getYritanVaria().equals("punainen")){
          pallot.getPallotArray().get(1).
                  setPalloVaraus(-varaus);
        }
        if (this.getPelaaja().getYritanVaria().equals("sininen")){
          pallot.getPallotArray().get(1).
                  setPalloVaraus(varaus);
        }       
    }
    
    
    public int getVuoro(){
        return this.vuoro;
    }
    
    public Pelaaja getPelaaja(){
        return this.pelaajat.get(this.vuoro);
    }
    
    /**
     * jos omat pallot loppu aloittaa yrittaa mustaa
     */
    public void alkaakoYrittaaMustaa(Reiat reiat){
        String vari = this.getPelaaja().getYritanVaria();
        // jos ollaan vasta alussa ei voida yrittää mustaa
        if (vari.equals("enTieda")){
            return;
        }
 
        int pussissa = reiat.getMitaReiissa().get(vari);
        if ((this.getPelaaja().getPallojaJaljella() -
                reiat.getMitaReiissa().get(vari)) == 0){     
            this.getPelaaja().setYritanMustaaPalloa(Boolean.TRUE);
        }
    }
    
    /**
     * Pallojen pysahdyttya tutkitaan mitä tapahtui
     * @param reiat kertovat mitä sisältävät
     * @return jatketaanko peliä
     */
    
    
    public Boolean tarkastaTilanne(Reiat reiat, Pallot pallot){
        // mitään ei mennyt reikiin, vaihdetaan vuoro, peli jatkuu
        if (reiat.getEkanaReiassa().equals("enTieda")){
            this.vaihdaVuoro();
            this.vaihdaVaraukset(pallot);
            return Boolean.TRUE;
        }
        
        // jos mustapallo meni reikään katsotaan kumpi voitti, peli ei jatku
        if (reiat.getMitaReiissa().get("musta").equals(1)){
            if (this.getPelaaja().getYritanMustaaPalloa()){
                this.getPelaaja().setVoittanut(Boolean.TRUE);
                this.vaihdaVuoro();
                this.getPelaaja().setHavinnyt(Boolean.TRUE);
                this.vaihdaVuoro();
            }
            else {
                this.getPelaaja().setHavinnyt(Boolean.TRUE);
                this.vaihdaVuoro();
                this.getPelaaja().setVoittanut(Boolean.TRUE);
                this.vaihdaVuoro();
            }            
            return Boolean.FALSE;
        }
        
        // pelaajien värit asetaan 
        // ensimmäisen pussituksen mukaan. Peli jatkuu.
        if (this.getPelaaja().getYritanVaria().equals("enTieda")){
            this.getPelaaja().setYritanVaria(reiat.getEkanaReiassa());
            // asetetaan toisen pelaajan tavoittelemien pallojen väri
            if (this.getPelaaja().getYritanVaria().equals("sininen")){
                this.vaihdaVuoro();
                this.getPelaaja().setYritanVaria("punainen");
                this.vaihdaVuoro();
            } else if (this.getPelaaja().getYritanVaria().equals("punainen")){
                this.vaihdaVuoro();
                this.getPelaaja().setYritanVaria("sininen");
                this.vaihdaVuoro();
            }   
        }
        
        
        // jos valkoinen pallo reikään niin vuoro vaihtuu. Peli jatkuu
        if (reiat.getMitaReiissa().get("valkoinen").equals(1)){
            this.vaihdaVuoro();
            this.vaihdaVaraukset(pallot);
        }
        
        
        // päivitetään pistetilanne
        
        return Boolean.TRUE;
    
    }
}

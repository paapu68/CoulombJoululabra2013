/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import mok.coulombphet.gui.Piirtoalusta;
import mok.coulombphet.peli.VelocityVerlet;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.peli.lisaaKiihtyvyydet;
import mok.coulombphet.pelilauta.Reiat;
import mok.coulombphet.pelilauta.Seina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import mok.coulombphet.pelilauta.LautaData;
import javax.swing.Timer;
import mok.coulombphet.gui.Paivitettava;
import mok.coulombphet.pelilauta.Keppi;

/**
 * Biljardipelin pyörityslogiikkaa, lisäksi metodit joilla saadaan
 * kaivettua pelin osia.
 * 
 */
public class Biljardipeli extends Timer implements ActionListener {
    private Pelaajat pelaajat;
    private Pallot pallot;
    private Reiat reiat;
    private Seina seina;
    private Pallo lyontipallo, mustapallo;
    private Keppi keppi;
    private Paivitettava paivitettava;
    private Boolean jatka, pallotliikkuu;
    private lisaaKiihtyvyydet lisaakiihtyvyydet;
    private LautaData lautadata;
    private VelocityVerlet nopeusVerlet;
    final double maxSiirtyma = 0.1, maxNopeus = 1.1,
            maxKiihtyvyys = 1.1;
   
    public Biljardipeli() {
        super(1, null);
        addActionListener(this);
        setInitialDelay(20);
        
        this.pelaajat = new Pelaajat();
        this.lisaakiihtyvyydet = new lisaaKiihtyvyydet();
        this.lautadata = new LautaData();        
        this.nopeusVerlet= new VelocityVerlet(this.lautadata.getDT());
        this.seina = new Seina();
        this.reiat = new Reiat();
        this.keppi = new Keppi();
        this.pallot = new Pallot();
        
        this.jatka = true;       
        this.pallotliikkuu = false;
        
        pallot.asetaPallojenAlkupaikat();
        pallot.asetaPallojenVaraukset(100);
        pallot.asetaPallojenVarit();       
        // testiLisays = new lisaaKiihtyvyydet();
    }
    
    public void juokse(){
        
        while (this.jatka){
          // ammutaan lyöntipallo
          setDelay(1);
          reiat.resetoiReiat();

          while (this.pallotliikkuu && this.jatka) {
            this.pallot.nollaaKiihtyvyydet();
            lisaakiihtyvyydet.lisaaCoulombKiihtyvyydetBiljardiPallot(this.pallot);
            lisaakiihtyvyydet.lisaaHardCoreKiihtyvyydet(this.pallot);
            lisaakiihtyvyydet.lisaaKitka(this.pallot);
            nopeusVerlet.PaivitaVelocityVerlet(this.pallot);
            seina.VaihdaLiikemaara(this.pallot);
            reiat.ekanaReiassa(pallot);
            reiat.lisaaReikiinMenneet(pallot);            
            pelaajat.alkaakoYrittaaMustaa(reiat);
            reiat.tapaNormiPallot(this.pallot);
            
            jatka = reiat.tarkastaPallo(pallot.getMustaPallo());
            
            if (!reiat.tarkastaPallo(pallot.getLyontiPallo())){
                System.out.println("LP reikään");
                this.pallot.arvoLyontiPallonPaikka(0, 0, 
                lautadata.getMaxLautaX(),lautadata.getMaxLautaY(), 0.20);
                this.pallotliikkuu = false;
                this.pallot.nollaaNopeudet();
                // tutkitaan mitä tapahtui
                jatka = pelaajat.tarkastaTilanne(reiat, pallot);                
            } else if (nopeusVerlet.getMaxSiirtyma() < maxSiirtyma &&
                    pallot.suurinNopeus() < this.maxNopeus){
                System.out.println("Checking alku");
                System.out.println(nopeusVerlet.getMaxSiirtyma());
                System.out.println(pallot.suurinNopeus());
                System.out.println(pallot.suurinKiihtyvyys());
                System.out.println("Checking -----------");
                System.out.println("Pallot pysähtyi");
                System.out.println(nopeusVerlet.getMaxSiirtyma());
                this.pallotliikkuu = false;
                this.pallot.nollaaNopeudet();
                nopeusVerlet.setMaxSiirtyma(1.0);
                // tutkitaan mitä tapahtui
                jatka = pelaajat.tarkastaTilanne(reiat,pallot);
            }
           
            // nollataan reikien tilanne uutta lyöntiä varten
          }
          
        }  
        jatka = pelaajat.tarkastaTilanne(reiat,pallot);
        System.out.println("Lopetetaan");
    }
    
    public Pallot getPallot(){
        return this.pallot;
    }
    
    public Pelaajat getPelaajat(){
        return this.pelaajat;
    }
    
    public Keppi getKeppi(){
        return this.keppi;
    }   
    
    public Reiat getReiat(){
        return this.reiat;
    }
    
    public Boolean getPallotLiikkuu(){
        return this.pallotliikkuu;
    }
    
    public void setPallotLiikkuu(Boolean pallotliikkuu){
        this.pallotliikkuu = pallotliikkuu;
    }
    
    public Boolean getJatka(){
        return this.jatka;
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {  
        //System.out.println("Pelissä action");
        paivitettava.paivita();
        //setDelay(100);
    }

}

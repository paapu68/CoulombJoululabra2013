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
import javax.swing.JFrame;
import mok.coulombphet.pelilauta.LautaData;
import javax.swing.Timer;
import mok.coulombphet.gui.Paivitettava;
import mok.coulombphet.pelilauta.Keppi;

/**
 *
 * @author mka
 */
public class Biljardipeli extends Timer implements ActionListener {
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
   
    public Biljardipeli() {
        super(1, null);
        addActionListener(this);
        setInitialDelay(20);
        
        Pallo lyontiPallo, mustaPallo;
        this.lisaakiihtyvyydet = new lisaaKiihtyvyydet();
        this.lautadata = new LautaData();        
        this.nopeusVerlet= new VelocityVerlet(this.lautadata.getDT());
        this.seina = new Seina();
        this.reiat = new Reiat();
        this.keppi = new Keppi();
        
        this.jatka = true;       
        this.pallotliikkuu = false;
        
        this.lyontipallo = new Pallo(0.7, 2.0, 0.0,0.0, 0.0,0.0, 0.16, 10,"valkoinen");
        this.mustapallo = new Pallo(0.7, 1.0, 0.0, 0.0, 0.0,0.0, 0.16, -20,"musta");
        this.pallot = new Pallot(lyontipallo, mustapallo, 
                lautadata.getPallonHalkaisija());
        // testiLisays = new lisaaKiihtyvyydet();
    }
    
    public void juokse(){
        
        while (this.jatka){
          // ammutaan lyöntipallo
          setDelay(20);  
          //System.out.println("Jatketaan");  
          //this.pallotliikkuu = true;
          while (this.pallotliikkuu) {
            this.pallot.nollaaKiihtyvyydet();
            lisaakiihtyvyydet.lisaaCoulombKiihtyvyydetBiljardiPallot(this.pallot);
            nopeusVerlet.PaivitaVelocityVerlet(this.pallot);

            seina.VaihdaLiikemaara(this.pallot);
            
            reiat.tapaNormiPallot(this.pallot);
            
            jatka = reiat.tarkastaPallo(this.mustapallo);
            
            if (!reiat.tarkastaPallo(this.lyontipallo)){
                System.out.println("LP reikään");
                this.pallot.arvoLyontiPallonPaikka(0, 0, 
                        lautadata.getMaxLautaX(), lautadata.getMaxLautaY(), 0.20);
            } 
            
       
            
            // ohjelmakoodi
            //System.out.println("xL:"+String.valueOf(lyontipallo.getPalloX()));
            //System.out.println("yL:"+String.valueOf(lyontipallo.getPalloY()));
   
            //System.out.println("xM:"+String.valueOf(mustapallo.getPalloX()));
            //System.out.println("yM:"+String.valueOf(mustapallo.getPalloY()));
          }
        }  
        System.out.println("Lopetetaan");
    }
    
    public Pallot getPallot(){
        return this.pallot;
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

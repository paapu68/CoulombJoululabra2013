package mok.coulombphet.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import mok.coulombphet.peli.Biljardipeli;
import mok.coulombphet.pelilauta.LautaData;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private LautaData lautadata;
    private Piirtoalusta piirtoalusta;
    private Biljardipeli biljardipeli;


    public Kayttoliittyma(Biljardipeli biljardipeli){
        this.biljardipeli = biljardipeli;
        this.lautadata = new LautaData();
        //System.out.println("RUN0");
        //System.exit(1);
    }
    

    
    @Override
    public void run() {
        frame = new JFrame("Biljardi");
        //System.out.println(lautadata.getpituusXpixel());
        //System.out.println(lautadata.getpituusYpixel());
        frame.setPreferredSize(new Dimension(
                2*lautadata.getpixelOffsetX()+lautadata.getpituusXpixel(),
                2*lautadata.getpixelOffsetY()+lautadata.getpituusYpixel()));
  
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
        luoKomponentit(frame.getContentPane());        
        
        frame.pack();
        frame.setVisible(true);
        //System.out.println("RUN");
        //System.exit(1);
        
    }
    
    private void luoKomponentit(Container container) {
        piirtoalusta = new Piirtoalusta(biljardipeli);
        container.add(piirtoalusta);
        NappaimistonKuuntelija n = 
                new NappaimistonKuuntelija(biljardipeli,
                piirtoalusta);
        getFrame().addKeyListener(n);
    }
 

    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }    
    
    public JFrame getFrame() {
        return frame;
    }
}
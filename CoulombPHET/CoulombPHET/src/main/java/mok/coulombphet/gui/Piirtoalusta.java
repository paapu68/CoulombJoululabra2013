package mok.coulombphet.gui;


import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import mok.coulombphet.peli.Biljardipeli;
import mok.coulombphet.pelilauta.Keppi;
import mok.coulombphet.pelilauta.LautaData;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.pelilauta.Reiat;
import mok.coulombphet.pelilauta.Seina;


/**
 * Alku varastettu kurssin Ohja materiaaleista
 * Piirretään pallot, reiät ja mahdollisesti lyöntikeppi.
 * xxx ei tehty pelitilanne
 */

public class Piirtoalusta extends JPanel implements Paivitettava{
    
    
    private Biljardipeli biljardipeli;
    private LautaData lautadata = new LautaData();
    
    public Piirtoalusta(Biljardipeli biljardipeli){
        // taustaväri
        super.setBackground(Color.GREEN);
        this.biljardipeli = biljardipeli;
    } 
    
    @Override
    public void paivita() {
        repaint();
    }    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.piirraPallot(g);
        this.piirraReiat(g);
        this.piirraKeppi(g);
    }       
    
    /**
     * Piirretään pallot pelilaudalle
     * @param g grafiikka 
     */
    public void piirraPallot(Graphics g) {
        ArrayList<Pallo> p1 = this.biljardipeli.getPallot().getPallotArray();
        for (Pallo pallo : p1) {   
            Integer pixelX = lautadata.lautaDouble2PixelX(pallo.getPalloX());
            Integer pixelY = lautadata.lautaDouble2PixelY(pallo.getPalloY());
       
            switch (pallo.getPalloVari()) {
                case "valkoinen":
                    g.setColor(Color.WHITE);
                    break;
                case "musta":
                    g.setColor(Color.BLACK);
                    break;
                default:
                    if (pallo.getPalloVaraus() < 0) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }   break;
            }
            g.fillOval(pixelX-lautadata.getpallonHalkaisijaPixel()/2, 
                    pixelY-lautadata.getpallonHalkaisijaPixel()/2,
                    lautadata.getpallonHalkaisijaPixel(),
                    lautadata.getpallonHalkaisijaPixel());
        }
    }
    
    /**
     * Piirretään reiat pelilaudalle
     * @param g grafiikka 
     */
    public void piirraReiat(Graphics g) {        
        ArrayList<Double> reiatX, reiatY;
        reiatX = this.biljardipeli.getReiat().getReiatX();
        reiatY = this.biljardipeli.getReiat().getReiatY();
        g.setColor(Color.PINK);
        for(int i = 0; i < reiatX.size(); i = i + 1) {
            g.fillOval(lautadata.lautaDouble2PixelX(reiatX.get(i))-
                    lautadata.getreianHalkaisijaPixel()/2,
                    lautadata.lautaDouble2PixelY(reiatY.get(i))-
                    lautadata.getreianHalkaisijaPixel()/2,
                    lautadata.getreianHalkaisijaPixel(),
                    lautadata.getreianHalkaisijaPixel()
            );
        }
    }    
/**
 * Lyontitilanteessa piirretään keppi
 * @param g grafiikka
 */
    public void piirraKeppi(Graphics g) {
        Pallo lyontipallo;
        Keppi keppi;
        double x1, x2, y1, y2;
        int pixelx1, pixelx2, pixely1, pixely2;
        
        if (this.biljardipeli.getJatka() && 
                !this.biljardipeli.getPallotLiikkuu()) {
            keppi = this.biljardipeli.getKeppi();
            lyontipallo = this.biljardipeli.getPallot().getLyontiPallo();
            //keppi = this.biljardipeli.
            //double dx1 = -lautadata.getKepinPituus() - keppi.getPoikkeama();
            //double dx2 = +lautadata.getKepinPituus() + keppi.getPoikkeama();
            double dx1 = -lautadata.getKepinPituus()/2.0 
                    - keppi.getPoikkeama() 
                    - this.lautadata.getPallonHalkaisija()/2;
            double dx2 = this.lautadata.getPallonHalkaisija()/2;
            x1 = lyontipallo.getPalloX() + 
                    dx1 * Math.cos(keppi.getKulmaRadian());                
            y1 = lyontipallo.getPalloY() + 
                    dx1 * Math.sin(keppi.getKulmaRadian());
            x2 = lyontipallo.getPalloX() + 
                    dx2 * Math.cos(keppi.getKulmaRadian());                      
            y2 = lyontipallo.getPalloY() + 
                    dx2 * Math.sin(keppi.getKulmaRadian()); 
                           
            pixelx1 = lautadata.lautaDouble2PixelX(x1);
            pixely1 = lautadata.lautaDouble2PixelY(y1);
            pixelx2 = lautadata.lautaDouble2PixelX(x2);
            pixely2 = lautadata.lautaDouble2PixelY(y2);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.gray);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(pixelx1, pixely1, pixelx2, pixely2);           
        }
    }        
}
    
    


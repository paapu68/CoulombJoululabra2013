package mok.coulombphet.gui;


import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import mok.coulombphet.peli.Biljardipeli;
import mok.coulombphet.pelilauta.LautaData;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.pelilauta.Reiat;
import mok.coulombphet.pelilauta.Seina;



public class Piirtoalusta extends JPanel implements Paivitettava{
    // Pohja kopioitu kurssilta ohja
    // piirtää pallot,  kohtaan x, y
    
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
    }       
    
    public int lautaDouble2PixelX(double x){
        // siirrytään reaalimaailman koordinaateista 
        // piirrettävän pelilaudan koordinaatteihin
        Double pixelXdouble;
        pixelXdouble = lautadata.getpixelOffsetX()+
                lautadata.getScale() * (x-lautadata.getMinLautaX());     
        return pixelXdouble.intValue();
    }
    
    public int lautaDouble2PixelY(double y){
        // siirrytään reaalimaailman koordinaateista 
        // piirrettävän pelilaudan koordinaatteihin
        Double pixelYdouble;
        pixelYdouble = lautadata.getpixelOffsetY()+
                lautadata.getScale() * (y-lautadata.getMinLautaY());
        return pixelYdouble.intValue();
    }    
        
    public void piirraPallot(Graphics g) {
        // Piirretään pallot pelilaudalle
        ArrayList<Pallo> p1 = this.biljardipeli.getPallot().getPallotArray();
        for (Pallo pallo : p1) {   
            Integer pixelX = this.lautaDouble2PixelX(pallo.getPalloX());
            Integer pixelY = this.lautaDouble2PixelY(pallo.getPalloY());
       
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
    
    public void piirraReiat(Graphics g) {
        // Piirretään reiat pelilaudalle
        ArrayList<Double> reiatX, reiatY;
        reiatX = this.biljardipeli.getReiat().getReiatX();
        reiatY = this.biljardipeli.getReiat().getReiatY();
        g.setColor(Color.PINK);
        for(int i = 0; i < reiatX.size(); i = i + 1) {
            g.fillOval(this.lautaDouble2PixelX(reiatX.get(i))-
                    lautadata.getreianHalkaisijaPixel()/2,
                    this.lautaDouble2PixelY(reiatY.get(i))-
                    lautadata.getreianHalkaisijaPixel()/2,
                    lautadata.getreianHalkaisijaPixel(),
                    lautadata.getreianHalkaisijaPixel()
            );
        }
    }        
    

     

}
    
    


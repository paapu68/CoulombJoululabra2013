package mok.coulombphet.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mok.coulombphet.peli.Biljardipeli;
import mok.coulombphet.pelilauta.Keppi;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;

/**
 *  Otettu kurssin Ohja materiaaleista
 *  kuunnellaan näppäimiä jotta saadaan lyötyä valkoista palloa
 *  ja käänneltyä lyöntikeppiä sekä säädeltyä lyöntivoimaa.
 * 
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    private Component component;
    private Biljardipeli biljardipeli;

    public NappaimistonKuuntelija(Biljardipeli biljardipeli, Component component) {
        this.biljardipeli = biljardipeli;
        this.component = component;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
     @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Pallo lyontipallo;
        Keppi keppi;
        if (!biljardipeli.getPallotLiikkuu()){
          if (e.getKeyCode() == KeyEvent.VK_LEFT) {
              this.biljardipeli.getKeppi().kierraVastapaivaan();
          } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
              this.biljardipeli.getKeppi().kierraMyotapaivaan();
          } else if (e.getKeyCode() == KeyEvent.VK_UP) {
              this.biljardipeli.getKeppi().viritaKeppia();
          } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
              this.biljardipeli.getKeppi().puraKeppia();
          } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
              
              lyontipallo = this.biljardipeli.getPallot().getLyontiPallo();
              keppi = this.biljardipeli.getKeppi();
              keppi.iske(lyontipallo);
              this.biljardipeli.setPallotLiikkuu(Boolean.TRUE);
          }
        }
        
        component.repaint();
    }

}

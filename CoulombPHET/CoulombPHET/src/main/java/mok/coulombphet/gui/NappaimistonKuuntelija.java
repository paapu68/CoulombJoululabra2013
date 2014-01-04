package mok.coulombphet.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mok.coulombphet.peli.Biljardipeli;
import mok.coulombphet.pelilauta.Pallot;

public class NappaimistonKuuntelija implements KeyListener {
    // varastettu kurssin Ohja materiaaleista
    // kuunnellaan näppäimiä jotta saadaan lyötyä valkoista palloa
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
        if (biljardipeli.)
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.biljardipeli.getPallot().kierraVastapaivaan();
            System.out.println("VASTA");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.biljardipeli.getPallot().kierraMyotapaivaan();
            System.out.println("MYÖTÄ");
        }

        component.repaint();
    }

}

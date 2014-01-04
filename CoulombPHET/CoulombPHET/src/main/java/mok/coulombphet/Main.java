/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

/**
 *
 * @author mka
 */
import mok.coulombphet.peli.Biljardipeli;
import javax.swing.SwingUtilities;
import mok.coulombphet.gui.Kayttoliittyma;

 
public class Main {
 
    public static void main(String[] args) {
        // kirjoita testikoodia tänne
        Biljardipeli biljardipeli = new Biljardipeli();
 
        Kayttoliittyma kali = new Kayttoliittyma(biljardipeli);
        SwingUtilities.invokeLater(kali);
 
        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
 
        biljardipeli.setPaivitettava(kali.getPaivitettava());
        biljardipeli.start();
        biljardipeli.juokse();
    }
}  


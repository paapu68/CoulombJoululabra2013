/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;
import java.util.ArrayList;    // imports ArrayList
/**
 *
 * @author mka
 */
public class Pallot {
    // an array of billiard balls
    private ArrayList<Pallo> pallot;  

    public Pallot() {
        this.pallot = new ArrayList<Pallo>();
    }

    public ArrayList<Pallo> getPallot() {
        return this.pallot;
    }
}

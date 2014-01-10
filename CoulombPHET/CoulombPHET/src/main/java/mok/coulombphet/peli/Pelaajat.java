/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.peli;

import java.util.ArrayList;

/**
 *
 * Pelaajien jono ja pelaajiin liittyvä toiminto (pelivuoro)
 */
public class Pelaajat {
    private ArrayList<Pelaaja> pelaajat;
    private int vuoro;
    
    public Pelaajat(){
        this.vuoro = 0;
    }
    
    public void vaihdaVuoro(){
        if (this.vuoro == 0){
            this.vuoro = 1;
        }
        else {
            this.vuoro = 0;
        }
    }
    
    public int getVuoro(){
        return this.vuoro;
    }
    
}

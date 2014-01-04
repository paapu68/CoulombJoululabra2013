/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mka
 */
public final class Reiat {
    private ArrayList<Double> reiatX = new ArrayList<Double>();
    private ArrayList<Double> reiatY = new ArrayList<Double>();
    private ArrayList<Integer> reiatXpixel = new ArrayList<Integer>();
    private ArrayList<Integer> reiatYpixel = new ArrayList<Integer>();    
    private final double reianSade = 0.05;
    private LautaData lautadata = new LautaData();
    
    public Reiat(){
        // alustetaan reiät paikoilleen        
        this.setReikaXY(0.0, 0.0);
        this.setReikaXY(lautadata.maxLautaX, 0.0);
        this.setReikaXY(0.0, lautadata.maxLautaY/2.0);
        this.setReikaXY(lautadata.maxLautaX, lautadata.maxLautaY/2.0);
        this.setReikaXY(0.0, lautadata.maxLautaY);
        this.setReikaXY(lautadata.maxLautaX, lautadata.maxLautaY);
    }
    
    public void setReikaXY(double x, double y){
        this.reiatX.add(x);
        this.reiatY.add(y);
    }
    
    public ArrayList<Double> getReiatX(){
        return this.reiatX;
    }
    
    public ArrayList<Double> getReiatY(){
        return this.reiatY;
    }
    
    public void tapaNormiPallot(Pallot pallot) {
        // jos normi pallo on reiässä se tapetaan pois
        ArrayList<Pallo> p1 = pallot.getPallotArray();
        ArrayList<Integer> tapa = new ArrayList<Integer>();
        Boolean found;
        double x, y, d;
        for(int i = p1.size()-1; i >= 2 ; i = i - 1) {
            x = p1.get(i).getPalloX();
            y = p1.get(i).getPalloY();
            found = false;
            for(int j = 0; j <= this.reiatX.size()-1 ; j = j + 1) {
                d = Math.sqrt((x-this.reiatX.get(j))*(x-this.reiatX.get(j))
                +(y-this.reiatY.get(j))*(y-this.reiatY.get(j)));
                if (d < this.reianSade) {
                    tapa.add(i);
                }
            }             
        }   
        for (int t1: tapa){
            pallot.poistaPallo(t1);
        }
    }
    
    public Boolean tarkastaPallo(Pallo pallo) {
        // jos pallo on reiässä palautetaan false, muuten true

        double x, y, d;
        boolean jatka = true;
        
        x = pallo.getPalloX();
        y = pallo.getPalloY();
        for(int j = 0; j <= this.reiatX.size()-1 ; j = j + 1) {
            d = Math.sqrt((x-this.reiatX.get(j))*(x-this.reiatX.get(j))
            +(y-this.reiatY.get(j))*(y-this.reiatY.get(j)));
            if (d < this.reianSade) {
                jatka = false;
            }
        }   
        return jatka;
    }    
    
    
}

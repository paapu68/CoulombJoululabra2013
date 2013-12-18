/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet.pelilauta;

/**
 *
 * @author mka, copied from OHJA
 */
public class Pallo {
    // contains position in 2d, charge of the ball
    // also 2d velocity, 2d acceleration and mass of a ball
    // also color of the ball
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int ax;
    private int ay;
    private float mass; 
    private int charge;
    private String color;

    public Pallo(int x, int y, int vx, int vy, int ax, int ay, 
            float mass, int charge, String color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.mass = mass;
        this.charge = charge;
        this.color = color;
    }

    public int getPalloX(){
        // the x coordinate is returned
        return this.x;
    }
    
    public int getPalloY(){
        // the y coordinate is returned
        return this.x;
    }
    
    public int getPalloCharge(){
        // the charge of the ball is returned
        return this.charge;
    }
    
    public int getPalloColor(){
        // the color of the ball is returned
        return this.charge;
    }
    
    @Override
    public String toString() {
        return this.x+", "+this.y+"  "+this.charge+"  "+this.color;
    }    
}    


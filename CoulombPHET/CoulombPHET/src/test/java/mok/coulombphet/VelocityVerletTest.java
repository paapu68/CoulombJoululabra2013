/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import mok.coulombphet.peli.VelocityVerlet;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;

/**
 *
 * @author mka
 */
public class VelocityVerletTest {
    VelocityVerlet askeltaja;
    Pallo lyontiPallo, mustaPallo;
    Pallot pallot;
    
    public VelocityVerletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        askeltaja = new VelocityVerlet(0.5);
        lyontiPallo = new Pallo(1.0, 1.0);
        mustaPallo = new Pallo(1.5, 1.5); 
        pallot = new Pallot();
        pallot.lisaaPallo(lyontiPallo);
        pallot.lisaaPallo(mustaPallo);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void askeltajaTest(){
        lyontiPallo.setPalloVX(1.0);
        lyontiPallo.setPalloVY(0.0);
        lyontiPallo.setPalloAX(2.0);
        lyontiPallo.setPalloAY(0.0);
        mustaPallo.setPalloVX(0.0);
        mustaPallo.setPalloVY(-1.0);
        mustaPallo.setPalloAX(0.0);
        mustaPallo.setPalloAY(-2.0);        
        askeltaja.PaivitaVelocityVerlet(pallot);
        double siirtyma =askeltaja.getMaxSiirtyma();
        double x0 = pallot.getPallotArray().get(0).getPalloX();
        double y1 = pallot.getPallotArray().get(1).getPalloY();
        // x: pitäisi tulla xold + v*dt + 0.5*ax*dt*dt
        // 1+1*0.5+0.5*2*0.5*0.5=1.75
        // y=1.5-1*0.5-0.5*2*0.5*0.5=0.75
        assertEquals(1.75, x0, 0.001);
        assertEquals(0.75, y1, 0.001);
        assertEquals(0.75, siirtyma, 0.001);
    }
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.newton.lisaaKiihtyvyydet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mka
 */
public class lisaaKiihtyvyydetTest {
    Pallo lyontiPallo, mustaPallo;
    Pallot testiPallot;
    lisaaKiihtyvyydet testiLisays;
    
    public lisaaKiihtyvyydetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lyontiPallo = new Pallo(1.0, 1.5, -5.0,-4.0, -3.0,-2.0, 0.16, -10,"valkoinen");
        mustaPallo = new Pallo(2.0, 0.5, -5.0,-4.0, -3.0,-2.0, 0.16, -10,"musta");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void onkoCoulombKiihtyvyydetOikeinTest() {
        // testataan tuleeko coulombin voima oikein
        
        testiPallot = new Pallot(lyontiPallo, mustaPallo);
        testiPallot.nollaaKiihtyvyydet();
        testiLisays = new lisaaKiihtyvyydet();
        testiLisays.lisaaCoulombKiihtyvyydetBiljardiPallot(testiPallot);
        double ax0 = testiPallot.getPallot().get(0).getPalloAX();
        double ax1 = testiPallot.getPallot().get(1).getPalloAX();
        
        double ay0 = testiPallot.getPallot().get(0).getPalloAY();
        double ay1 = testiPallot.getPallot().get(1).getPalloAY();
         
        assertEquals(3.97, ax0, 0.1);
        assertEquals(-3.97, ay0, 0.1);
        
        //assertEquals("musta", variMustaPallo);
            
    }
}
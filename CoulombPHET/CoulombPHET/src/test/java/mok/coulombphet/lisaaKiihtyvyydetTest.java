/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.peli.lisaaKiihtyvyydet;
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
        lyontiPallo = new Pallo(1.0, 1.5);
        mustaPallo = new Pallo(2.0, 0.5);
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
        
        testiPallot = new Pallot();
        lyontiPallo.setPalloVaraus(-10);
        mustaPallo.setPalloVaraus(-10);
        testiPallot.lisaaPallo(lyontiPallo);
        testiPallot.lisaaPallo(mustaPallo);
        
        testiPallot.nollaaKiihtyvyydet();
        testiLisays = new lisaaKiihtyvyydet();
        testiLisays.lisaaCoulombKiihtyvyydetBiljardiPallot(testiPallot);
        double ax0 = testiPallot.getPallotArray().get(0).getPalloAX();
        double ax1 = testiPallot.getPallotArray().get(1).getPalloAX();
        
        double ay0 = testiPallot.getPallotArray().get(0).getPalloAY();
        double ay1 = testiPallot.getPallotArray().get(1).getPalloAY();
         
        assertEquals(-3.97, ax0, 0.1);
        assertEquals(3.97, ay0, 0.1);
        
        //assertEquals("musta", variMustaPallo);
            
    }
    

   @Test
    public void lisaaHardCoreKiihtyvyydetTest() {
        // testataan tuleeko HardCore voima oikein        
        testiPallot = new Pallot();
        lyontiPallo.setPalloX(0.1);
        lyontiPallo.setPalloY(0.0);
        mustaPallo.setPalloX(0.0);
        mustaPallo.setPalloY(0.0);
        testiPallot.lisaaPallo(lyontiPallo);
        testiPallot.lisaaPallo(mustaPallo);        
        testiPallot.nollaaKiihtyvyydet();
        testiLisays = new lisaaKiihtyvyydet();
        testiLisays.lisaaHardCoreKiihtyvyydet(testiPallot);
        double ax0 = testiPallot.getPallotArray().get(0).getPalloAX();
        double ay0 = testiPallot.getPallotArray().get(0).getPalloAY();        
        // pitäisi tulla 1e-13*0.1/((0.1- 0.0517/2)^10*0.16)
        // 0.01243851298 m/s²
        assertEquals(0.01243851298, ax0, 0.001);
        assertEquals(0.0, ay0, 0.1);
    }    
    
   @Test
    public void lisaaKitkaTest() {
        // testataan tuleeko kitka voima oikein        
        testiPallot = new Pallot();
        lyontiPallo.setPalloX(0.1);
        lyontiPallo.setPalloY(0.0);
        lyontiPallo.setPalloVX(0.0);
        lyontiPallo.setPalloVY(-11.0);
        testiPallot.lisaaPallo(lyontiPallo);     
        testiPallot.nollaaKiihtyvyydet();
        testiLisays = new lisaaKiihtyvyydet();
        testiLisays.lisaaKitka(testiPallot);
        double ax0 = testiPallot.getPallotArray().get(0).getPalloAX();
        double ay0 = testiPallot.getPallotArray().get(0).getPalloAY();        
        // pitäisi tulla +y suuntaan kiihtyvyys
        // kitkaKerroin * gravitaatioVakio
        // = 100*9.81 = 981.0
        assertEquals(0.0, ax0, 0.001);
        assertEquals(981.00, ay0, 0.1);
    }        
}
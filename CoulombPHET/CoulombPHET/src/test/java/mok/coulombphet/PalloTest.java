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
import mok.coulombphet.pelilauta.Pallo;

/**
 *
 * @author mka
 */
public class PalloTest {
    Pallo pallo;
    
    public PalloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pallo = new Pallo(0.25, 0.30);
        //pallo = new Pallo(0.25, 0.30, -5.0,-4.0, -3.0,-2.0, 50.0, -1,"kelt");
        pallo.setPalloVX(-5.0);
        pallo.setPalloVY(-4.0);
        pallo.setPalloAX(-3.0);
        pallo.setPalloAY(-2.0);
        pallo.setPalloVaraus(-1);
        pallo.setPalloVari("kelt");
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
    public void getPalloXtest() {
        double vastaus = pallo.getPalloX();
        assertEquals(0.25, vastaus, 0.001);
    }
    @Test
    public void getPalloYtest() {
        double vastaus = pallo.getPalloY();
        assertEquals(0.3, vastaus, 0.001);
    }    
    @Test
    public void getPalloVXtest() {
        double vastaus = pallo.getPalloVX();
        assertEquals(-5.0, vastaus, 0.001);
    }
    @Test
    public void getPalloVYtest() {
        double vastaus = pallo.getPalloVY();
        assertEquals(-4.0, vastaus, 0.001);
    }
    @Test
    public void getPalloAXtest() {
        double vastaus = pallo.getPalloAX();
        assertEquals(-3.0, vastaus, 0.001);
    }
    @Test
    public void getPalloAYtest() {
        double vastaus = pallo.getPalloAY();
        assertEquals(-2.0, vastaus, 0.001);
    }    

    @Test
    public void getPalloVaritest() {
        String vastaus = pallo.getPalloVari();
        assertEquals("kelt", vastaus);
    }
    @Test
    public void setPalloXtest() {
        pallo.setPalloX(0.4);
        double vastaus = pallo.getPalloX();
        assertEquals(0.4, vastaus, 0.001);
    }    
    public void setPalloYtest() {
        pallo.setPalloY(0.5);
        double vastaus = pallo.getPalloY();
        assertEquals(0.5, vastaus, 0.001);
    }     
    @Test
    public void setPalloVXtest() {
        pallo.setPalloVX(50.0);
        double vastaus = pallo.getPalloVX();
        assertEquals(50.0, vastaus, 0.001);
    }        
    @Test
    public void setPalloVYtest() {
        pallo.setPalloVY(60.0);
        double vastaus = pallo.getPalloVY();
        assertEquals(60.0, vastaus, 0.001);
    } 
    @Test
    public void setPalloAXtest() {
        pallo.setPalloAX(1.0);
        double vastaus = pallo.getPalloAX();
        assertEquals(1.0, vastaus, 0.001);
    } 
    @Test
    public void setPalloAYtest() {
        pallo.setPalloAY(2.0);
        double vastaus = pallo.getPalloAY();
        assertEquals(2.0, vastaus, 0.001);
    }     
   

    @Test
    public void setPalloVarausTest() {
        pallo.setPalloVaraus(-3);
        double vastaus = pallo.getPalloVaraus();
        assertEquals(-0.000003, vastaus,0.00000001);
    }   
    @Test
    public void setPalloVariTest() {
        pallo.setPalloVari("must");
        String vastaus = pallo.getPalloVari();
        assertEquals("must", vastaus);
    }
    @Test 
    public void lisaaPalloAXTest() {
        pallo.setPalloAX(0.0);
        pallo.lisaaPalloAX(2.0);
        double vastaus = pallo.getPalloAX();
        assertEquals(2.0, vastaus,0.00000001);
    }   
    @Test 
    public void lisaaPalloAYTest() {
        pallo.setPalloAY(0.0);
        pallo.lisaaPalloAY(-3.0);
        double vastaus = pallo.getPalloAY();
        assertEquals(-3.0, vastaus,0.00000001);
    }       
}

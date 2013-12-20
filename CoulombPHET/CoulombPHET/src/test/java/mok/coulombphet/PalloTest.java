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
        pallo = new Pallo(2, 3, -5.0,-4.0, -3.0,-2.0, 50.0, -1,"kelt");
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
        int vastaus = pallo.getPalloX();
        assertEquals(2, vastaus);
    }
    @Test
    public void getPalloYtest() {
        int vastaus = pallo.getPalloY();
        assertEquals(3, vastaus);
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
    public void getPalloMassatest() {
        double vastaus = pallo.getPalloMassa();
        assertEquals(50.0, vastaus, 0.001);
    }

    @Test
    public void getPalloVaritest() {
        String vastaus = pallo.getPalloVari();
        assertEquals("kelt", vastaus);
    }
    @Test
    public void setPalloXtest() {
        pallo.setPalloX(30);
        int vastaus = pallo.getPalloX();
        assertEquals(30, vastaus);
    }    
    public void setPalloYtest() {
        pallo.setPalloY(40);
        int vastaus = pallo.getPalloY();
        assertEquals(40, vastaus);
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
    public void setPalloMassatest() {
        pallo.setPalloMassa(20.0);
        double vastaus = pallo.getPalloMassa();
        assertEquals(20.0, vastaus, 0.001);
    }
    @Test
    public void setPalloVarausTest() {
        pallo.setPalloVaraus(-3);
        int vastaus = pallo.getPalloVaraus();
        assertEquals(-3, vastaus);
    }   
    @Test
    public void setPalloVariTest() {
        pallo.setPalloVari("must");
        String vastaus = pallo.getPalloVari();
        assertEquals("must", vastaus);
    }    
}

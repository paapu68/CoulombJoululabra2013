/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import mok.coulombphet.pelilauta.Keppi;
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
public class KeppiTest {
    Keppi keppi;  
    public KeppiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        keppi = new Keppi();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kierraVastapaivaanTest() {
        keppi.kierraVastapaivaan();
        double vastaus = keppi.getKulmaRadian();
        assertEquals(271.0/360.0*2.0*Math.PI, vastaus, 0.001);
    }
    
    @Test
    public void getPoikkeamaTest() {
        double vastaus = keppi.getPoikkeama();
        assertEquals(0.01, vastaus, 0.001);
    }
    
    //@Test
    //public void getVoimaTest() {
    //    double vastaus = keppi.getVoima();
    //    assertEquals(-1000000.0, vastaus, 0.001);
    //}
}

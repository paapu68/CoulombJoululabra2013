package mok.coulombphet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
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
public class PallotTest {
    Pallo lyontiPallo, mustaPallo, pallo0;
   
    public PallotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lyontiPallo = new Pallo(1.0, 2.0);
        mustaPallo = new Pallo(0.5, 1.5);
        pallo0 = new Pallo(0.1, 0.2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getPallotTest() {
        Pallot pallot = new Pallot();
        pallot.lisaaPallo(lyontiPallo);
        pallot.lisaaPallo(mustaPallo);
        pallot.lisaaPallo(pallo0);
        ArrayList<Pallo> uudetpallot = pallot.getPallotArray();
        double x0 = pallot.getPallotArray().get(0).getPalloX();
        double x1 = pallot.getPallotArray().get(1).getPalloX();
        double y2 = pallot.getPallotArray().get(2).getPalloY();
        assertEquals(1.0, x0, 0.001);
        assertEquals(0.5, x1, 0.001);
        assertEquals(0.2, y2, 0.001);
    }
}

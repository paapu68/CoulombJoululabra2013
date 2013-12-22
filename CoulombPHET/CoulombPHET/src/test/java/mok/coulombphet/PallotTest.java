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
    Pallo pallo0;
    Pallo pallo1;
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
        pallo0 = new Pallo(2, 3, -5.0,-4.0, -3.0,-2.0, 50.0, -1,"kelt");
        pallo1 = new Pallo(10, 20, -5.0,-4.0, -3.0,-2.0, 50.0, -1,"must");
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
    public void getPallotTest() {
        Pallot pallot = new Pallot();
        pallot.lisaaPallo(pallo1);
        pallot.lisaaPallo(pallo0);
        ArrayList<Pallo> uudetpallot = pallot.getPallot();
        String vari0 = pallot.getPallot().get(0).getPalloVari();
        String vari1 = pallot.getPallot().get(1).getPalloVari();        
        assertEquals("must", vari0);
        assertEquals("kelt", vari1);
    }
}

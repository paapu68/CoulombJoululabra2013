/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.pelilauta.Seina;
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
public class SeinaTest {
    Pallo lyontiPallo, mustaPallo;
    Pallot pallot;
    Seina seina;
    public SeinaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lyontiPallo = new Pallo(2.0, 3.0);
        mustaPallo = new Pallo(10.0, 20.0);
        pallot = new Pallot();
        pallot.lisaaPallo(lyontiPallo);
        pallot.lisaaPallo(mustaPallo);
        seina = new Seina();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ylaXkimpousTest() {
        double ylax = this.seina.getYlax();
        this.lyontiPallo.setPalloX(ylax);
        this.lyontiPallo.setPalloVX(10);
        seina.VaihdaLiikemaara(pallot);
        double vastaus = pallot.getPallotArray().get(0).getPalloVX();
        assertEquals(-10, vastaus, 0.001);
    }
}

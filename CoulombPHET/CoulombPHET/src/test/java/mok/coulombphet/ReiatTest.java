/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import mok.coulombphet.pelilauta.Pallo;
import mok.coulombphet.pelilauta.Pallot;
import mok.coulombphet.pelilauta.Reiat;
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
public class ReiatTest {
    Pallo lyontiPallo, mustaPallo;
    Pallot testiPallot;    
    Reiat reiat;
    
    public ReiatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lyontiPallo = new Pallo(0.0, 0.0);
        mustaPallo = new Pallo(2.0, 0.5);
        reiat = new Reiat();
    }
    
    @After
    public void tearDown() {
    }
   @Test
   public void tapaNormiPallotTest(){
       // tapetaan normipallot (pallot 2-) jotka ovat menneet reikiin.
       // nyt pitäisi tappaa pallot 2 ja 4
       testiPallot = new Pallot();
       testiPallot.lisaaPallo(lyontiPallo);
       testiPallot.lisaaPallo(mustaPallo);
       Pallo normi1 = new Pallo(0.0, 0.0);
       Pallo normi2 = new Pallo(0.5, 0.5);
       Pallo normi3 = new Pallo(1.4, 1.35);  
       testiPallot.lisaaPallo(normi1);
       testiPallot.lisaaPallo(normi2);
       testiPallot.lisaaPallo(normi3);
       reiat.tapaNormiPallot(testiPallot);
       int pituus = testiPallot.getPallotArray().size();
       assertEquals(3, pituus);
       double x = testiPallot.getPallotArray().get(2).getPalloX();
       assertEquals(0.5, x, 0.01);        
   }    
    
   @Test
    public void tarkastaPalloTest() {
        //tapetaanko pallo jos se on reiassa?    
        // lyontipallon pitaisi olla, mustan ei
        testiPallot = new Pallot();
        testiPallot.lisaaPallo(lyontiPallo);
        testiPallot.lisaaPallo(mustaPallo);
        boolean elossa1 = reiat.tarkastaPallo(lyontiPallo);
        boolean elossa2 = reiat.tarkastaPallo(mustaPallo);
        assertEquals(false, elossa1);
        assertEquals(true, elossa2);
    }
}

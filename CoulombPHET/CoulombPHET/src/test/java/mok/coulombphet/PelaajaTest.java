/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mok.coulombphet;

import mok.coulombphet.peli.Pelaaja;
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
public class PelaajaTest {
    Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void vahennaPallojaJaljellaTest(){
        pelaaja.vahennaPallojaJaljella(1);
        pelaaja.vahennaPallojaJaljella(2);
        assertEquals(4, pelaaja.getPallojaJaljella());
    }
    
    @Test
    public void setYritanVariaTest(){
        pelaaja.setYritanVaria("valkoinen");
        assertEquals("enTieda", pelaaja.getYritanVaria());
        pelaaja.setYritanVaria("punainen");
        assertEquals("punainen", pelaaja.getYritanVaria());
        pelaaja.setYritanVaria("musta");
        assertEquals("musta", pelaaja.getYritanVaria());
        pelaaja.setYritanVaria("sininen");
        assertEquals("sininen", pelaaja.getYritanVaria());
    }
      
    
}

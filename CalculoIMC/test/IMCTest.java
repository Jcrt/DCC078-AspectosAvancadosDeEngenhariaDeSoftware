/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import org.junit.Before;

/**
 *
 * @author Julio R. Trindade
 */
public class IMCTest extends TestCase {
    
    private IMC im;
    
    public IMCTest() {
        
    }
    
    @Before
    public void setUp() {
        this.im = new IMC();
        im.setAltura(1);
    } 
    
    public void testCalculoIMC(){
        im.setPeso(73);
        im.setAltura(1.68);
        assertEquals(25.86, im.calculoIMC(), 0);
    }
    
    public void testResultadoIMC_HomemAbaixoPeso(){
        im.setSexo(true);
        im.setPeso(20.6);
        assertEquals("abaixo do peso", im.resultadoIMC());
    }
    
    public void testResultadoIMC_MulherAbaixoPeso(){
        im.setSexo(false);
        im.setPeso(19);
        assertEquals("abaixo do peso", im.resultadoIMC());
    }
    
    public void testResultadoIMC_HomemPesoNormal(){
        im.setSexo(true);
        im.setPeso(26.3);
        assertEquals("no peso normal", im.resultadoIMC());
    }
    
    public void testResultadooIMC_MulherPesoNormal(){
        im.setSexo(false);
        im.setPeso(25.7);
        assertEquals("no peso normal", im.resultadoIMC());
    }
    
    public void testResultadoIMC_HomemMarginalmenteAcimaPeso(){
        im.setSexo(true);
        im.setPeso(27.7);
        assertEquals("marginalmente acima do peso", im.resultadoIMC());
    }
    
    public void testResultadoIMC_MulherMarginalmenteAcimaPeso(){
        im.setSexo(false);
        im.setPeso(27.2);
        assertEquals("marginalmente acima do peso", im.resultadoIMC());
    }
    
    public void testResultadoIMC_HomemAcimaPeso(){
        im.setSexo(true);
        im.setPeso(31);
        assertEquals("acima do peso ideal", im.resultadoIMC());
    }
    
    public void testResultadoIMC_MulherAcimaPeso(){
        im.setSexo(false);
        im.setPeso(32.2);
        assertEquals("acima do peso ideal", im.resultadoIMC());
    }
    
    public void testResultadoIMC_HomemObeso(){
        im.setSexo(true);
        im.setPeso(31.1);
        assertEquals("Obeso", im.resultadoIMC());
    }
    
    public void testResultadoIMC_MulherObeso(){
        im.setSexo(false);
        im.setPeso(32.3);
        assertEquals("Obeso", im.resultadoIMC());
    }
}

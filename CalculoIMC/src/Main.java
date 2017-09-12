/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio R. Trindade
 */
public class Main {
    public static void main (String [] args){
        IMC imc = new IMC();
        imc.setAltura(1.68);
        imc.setPeso(73);
        double doubleimc = imc.calculoIMC();
    }
}

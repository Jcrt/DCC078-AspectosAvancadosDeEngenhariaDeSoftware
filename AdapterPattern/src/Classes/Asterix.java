/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.IGuerreiro;

/**
 *
 * @author Julio R. Trindade
 */
public class Asterix implements IGuerreiro {

    @Override
    public String cortar() {
        return "Asterix sacou a espada e cortou ao meio o inimigo";
    }

    @Override
    public String bloquearComEscudo() {
        return "Asterix levantou o escudo e evitou o ataque";
    }
    
}

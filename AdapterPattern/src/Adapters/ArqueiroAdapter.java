/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Classes.Legolas;
import Interfaces.IMago;

/**
 *
 * @author Julio R. Trindade
 */
public class ArqueiroAdapter implements IMago {
    private Legolas legolas;
    
    public ArqueiroAdapter(){
        this.legolas = new Legolas();
    }
    
    @Override
    public String lancarFeitico() {
        return legolas.atirarFlecha();
    }

    @Override
    public String barreiraMagica() {
        return legolas.esquiva();
    }

    @Override
    public String getQuemSouEu() {
        return "Legolas, o arqueiro ";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Classes.Asterix;
import Interfaces.IMago;

/**
 *
 * @author Julio R. Trindade
 */
public class GuerreiroAdapter implements IMago {
    private Asterix asterix;
    
    public GuerreiroAdapter(){
        this.asterix = new Asterix();
    }
    
    @Override
    public String lancarFeitico() {
        return asterix.cortar();
    }

    @Override
    public String barreiraMagica() {
        return asterix.bloquearComEscudo();
    }

    @Override
    public String getQuemSouEu() {
        return "Asterix, o gaulês ";
    }
}

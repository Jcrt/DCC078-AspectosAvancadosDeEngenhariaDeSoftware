/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.IMago;

/**
 *
 * @author Julio R. Trindade
 */
public class Merlin implements IMago {

    @Override
    public String lancarFeitico() {
        return "Merlim recitou o encantamento 'La-CAR-nium In-fla-MA-rÃum' e chamas azuiz surgiram!";
    }

    @Override
    public String barreiraMagica() {
        return "Merlim levantou uma barreira mágica igual á parede de cristal do Mú, cavalheiro de Áries!";
    }

    @Override
    public String getQuemSouEu() {
        return "Merlin, o Grande Mago ";
    }
    
}

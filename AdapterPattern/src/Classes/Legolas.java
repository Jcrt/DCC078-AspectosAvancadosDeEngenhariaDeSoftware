/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.IArqueiro;

/**
 *
 * @author Julio R. Trindade
 */
public class Legolas implements IArqueiro {
    
    @Override
    public String atirarFlecha() {
        return "Legolas atirou uma flecha entre os olhos do inimigo. Mas que mira!!!";
    }

    @Override
    public String esquiva() {
        return "Legolas desviou do ataque tipo o Neil do Matrix! No estilo!!";
    }
    
}

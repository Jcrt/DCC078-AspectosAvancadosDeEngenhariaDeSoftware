/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TipoPessoaEnum;

/**
 *
 * @author 07228620674
 */
public class PessoaCliente extends Pessoa {

    @Override
    public String getTipoDocumento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTipo() {
        return TipoPessoaEnum.CLIENTE.getValor();
    }
    
}

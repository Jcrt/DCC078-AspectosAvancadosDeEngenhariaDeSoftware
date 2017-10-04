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
public class PessoaOutro extends Pessoa {

    @Override
    public String getTipoDocumento() {
        return "RG: ";
    }

    @Override
    public int getTipo() {
        return TipoPessoaEnum.OUTROS.getValor();
    }
    
}

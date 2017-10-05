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
public class PessoaAdvogado extends Pessoa {

    public PessoaAdvogado(int id, String nome) {
        super(id, nome);
    }
    
    @Override
    public String getTipoDocumento() {
        return "OAB"; 
    }

    @Override
    public int getTipo(){
        return TipoPessoaEnum.ADVOGADO.getValor();
    }
}

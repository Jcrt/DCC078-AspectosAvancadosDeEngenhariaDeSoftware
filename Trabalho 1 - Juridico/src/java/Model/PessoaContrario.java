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
public class PessoaContrario extends Pessoa {

    public PessoaContrario() {
    }

    public PessoaContrario(int id, String nome) {
        super(id, nome);
    }

    public PessoaContrario(int id, String nome, String documento, String email) {
        super(id, nome, documento, email);
    }

    @Override
    public String getTipoDocumento() {
        return "RG";
    }

    @Override
    public int getTipoEnum() {
        return TipoPessoaEnum.CONTRARIO.getValor();
    }

    @Override
    public String getTipo() {
        return "Contrário";
    }

}

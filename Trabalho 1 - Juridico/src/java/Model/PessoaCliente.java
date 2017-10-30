/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TipoEnvolvimentoEnum;

/**
 *
 * @author 07228620674
 */
public class PessoaCliente extends Pessoa {

    public PessoaCliente() {
    }

    public PessoaCliente(int id, String nome) {
        super(id, nome);
    }

    public PessoaCliente(int id, String nome, String documento, String email) {
        super(id, nome, documento, email);
    }

    @Override
    public String getTipoDocumento() {
        return "RG";
    }

    @Override
    public int getTipoEnum() {
        return TipoEnvolvimentoEnum.CLIENTE.getValor();
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }
}

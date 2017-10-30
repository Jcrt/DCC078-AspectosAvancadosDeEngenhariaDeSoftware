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
public class PessoaAdvogado extends Pessoa {

    public PessoaAdvogado() {
    }
    
    public PessoaAdvogado(int id, String nome) {
        super(id, nome);
    }
    
     public PessoaAdvogado(int id, String nome, String numeroDocumento, String email) {
        super(id, nome, numeroDocumento,email);
    }
    
    @Override
    public String getTipoDocumento() {
        return "OAB"; 
    }

    @Override
    public int getTipoEnum(){
        return TipoEnvolvimentoEnum.ADVOGADO.getValor();
    }

    @Override
    public String getTipo() {
        return "Advogado";
    }
}

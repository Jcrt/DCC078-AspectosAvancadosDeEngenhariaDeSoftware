/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 07228620674
 */
public class AndamentoNaoLido extends Andamento {

    public AndamentoNaoLido(String descricao) {
        super(descricao);
    }

    @Override
    public String getLeitoresAndamento() {
        return "Nenhum envolvido leu este andamento até o momento";
    }
    
}

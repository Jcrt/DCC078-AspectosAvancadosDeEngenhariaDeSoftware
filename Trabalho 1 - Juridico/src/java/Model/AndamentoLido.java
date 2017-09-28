/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author 07228620674
 */
public class AndamentoLido extends Andamento {
    
    private List<AndamentoLeituraDados> leitoresAndamento;
    
    

    @Override
    public String getStatusLido() {
        return "Lido por: ";
    }
}

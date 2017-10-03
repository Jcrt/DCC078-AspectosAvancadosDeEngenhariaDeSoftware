/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 07228620674
 */
public class AndamentoLido extends Andamento {
    
    private final List<AndamentoLeituraDados> leitoresAndamento;
    
    public AndamentoLido(){
        this.leitoresAndamento = new ArrayList<>();
    }
    
    @Override
    public String getLeitoresAndamento() {
        String dadosLeitura = "";
        dadosLeitura = leitoresAndamento.stream()
                            .map((AndamentoLeituraDados a) -> a.getLeitor().getNome() 
                                    +"[" + a.getData()+ "]; "
                            )
                            .reduce(dadosLeitura, String::concat);
        
        return "Lido por: " + dadosLeitura;
    }
}

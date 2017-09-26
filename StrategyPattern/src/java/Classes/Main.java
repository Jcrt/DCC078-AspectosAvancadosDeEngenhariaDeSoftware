/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 07228620674
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        Produto prod1 = new TV();
        Produto prod2 = new Camera();
        Produto prod3 = new Celular();
        
        System.out.println(prod1.getTipoImpressao() + prod1.getNome() 
                + " na promoção " + prod1.getPromocao() +
                " com desconto de " + prod1.getDesconto() + "%");
        
        System.out.println(prod2.getTipoImpressao() + prod2.getNome() 
                + " na promoção " + prod2.getPromocao() +
                " com desconto de " + prod2.getDesconto() + "%");
        
        System.out.println(prod3.getTipoImpressao() + prod3.getNome() 
                + " na promoção " + prod3.getPromocao() +
                " com desconto de " + prod3.getDesconto() + "%");
    }
}

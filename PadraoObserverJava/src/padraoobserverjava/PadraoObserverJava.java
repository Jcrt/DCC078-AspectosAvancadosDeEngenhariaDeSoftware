/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraoobserverjava;

/**
 *
 * @author 07228620674
 */
public class PadraoObserverJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int novaEdicao = 3;
        Revista revista = new Revista();
        Assinante assinante1 = new Assinante(revista);
        assinante1.setNome("Julio");
        Assinante assinante2 = new Assinante(revista);
        assinante2.setNome("Cesar");
        revista.setEdicao(novaEdicao);
    }
    
}

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
public class Camera extends Produto {
    public Camera(){
        this.nome = "Câmera";
        this.promocao = new PromocaoDiaMaes();
        this.impressao = new ImpressaoPDF();
    }
}

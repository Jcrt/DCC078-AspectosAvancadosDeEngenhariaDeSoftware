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
public class Advogado extends Pessoa {
    
    @Override
    public String getTipoDocumento() {
        return "OAB"; 
    }
}

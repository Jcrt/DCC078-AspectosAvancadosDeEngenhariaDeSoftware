/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Fase;

/**
 *
 * @author 07228620674
 */
public interface IPessoa {
    
    public int getTipoEnum();
    
    public String getTipoDocumento();
    
    public String getTipo();

    public String getNome();

    public String getEmail();

    public String getNumeroDocumento();

    public int getId();
    
}

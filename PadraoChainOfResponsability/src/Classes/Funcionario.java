/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Julio R. Trindade
 */
public abstract class Funcionario {
    protected ArrayList listaDocumentos = new ArrayList();
    private Funcionario funcionarioSuperior;

    public ArrayList getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncionarioSuperior(Funcionario funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }
    
    public abstract String getDescricaoCargo();
    
    public String assinarDocumento(Documento documento){
        if(listaDocumentos.contains(documento.getTipoDocumento())){
            return getDescricaoCargo();
        } else{
            if(funcionarioSuperior != null){
                return funcionarioSuperior.assinarDocumento(documento);
            } else{
                return "Sem assinatura";
            }
        }
    }
}

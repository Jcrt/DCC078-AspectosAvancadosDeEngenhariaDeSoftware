/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Julio R. Trindade
 */
public class FuncionarioDiretor extends Funcionario {
    public FuncionarioDiretor(Funcionario superior){
        listaDocumentos.add(RolDocumentos.getInstance().getTipoDocumentoCertificado());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Diretor";
    }
}

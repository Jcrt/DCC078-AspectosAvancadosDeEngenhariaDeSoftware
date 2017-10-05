/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Pessoa;
import Persistencia.PessoaAdvogadoDAO;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thassya
 */
public class ListaPessoasAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        
        //listaPessoas = (ArrayList<Pessoa>) PessoaAdvogadoDAO.getInstance().listar();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ContatoDAO;
import DAO.ProdutoDAO;
import Models.Contato;
import Models.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio R. Trindade
 */
public class AlterarEstoqueProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try {
            int idProduto = Integer.parseInt((String) request.getParameter("idProduto"));
            int estoque = Integer.parseInt((String) request.getParameter("estoque"));
            
            ProdutoDAO pDAO = ProdutoDAO.getInstance();
            ContatoDAO cDAO = ContatoDAO.getInstance();
            
            Produto p = pDAO.ler(idProduto);
            
            List<Contato> c = cDAO.listarObservadorProduto(p);
            
            p.setEstoque(estoque);
            
        } catch (Exception e) {
            
        }
        
        
        
    }
}

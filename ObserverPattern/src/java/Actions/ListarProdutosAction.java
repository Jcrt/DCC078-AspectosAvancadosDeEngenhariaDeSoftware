/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProdutoDAO;
import Models.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 07228620674
 */
public class ListarProdutosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProdutoDAO pDAO = ProdutoDAO.getInstance();
        
        try {
            
            List<Produto> prods = new ArrayList<>();
            for(Produto prod : pDAO.listar()){
                if(prod.getEstoque() == 0){
                    prods.add(prod);
                }
            }

            request.setAttribute("ProdutosList", prods);
            RequestDispatcher rd = request.getRequestDispatcher("ListarProdutos.jsp");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarProdutosAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarProdutosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

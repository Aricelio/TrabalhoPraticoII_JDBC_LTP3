/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DominModel.*; //Importando o Pacote DominModel
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alisson 02
 */
public class VendaDAO extends DAO{
    
    public VendaDAO(){
        super();
    }
    /*--------------------- Método Salvar ------------------------------------*/
    public boolean Salvar(Venda obj){
        if (obj.getCodigo() == 0) 
        {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into vendas(valorTotal,data,codPessoa) values(?,?,?)");
                sql.setDouble(1, obj.getValorTotal());                
                sql.setDate(2, new java.sql.Date(obj.getData().getTime()));  
                sql.setInt(3, obj.getPessoa().getCodigo());
                sql.executeUpdate();
                
                
                PreparedStatement sql2 = getConexao().prepareStatement("select codVenda from Vendas where valorTotal = ? and Data = ?");
                sql2.setDouble(1, obj.getValorTotal());                
                sql2.setDate(2, new java.sql.Date(obj.getData().getTime())); 
                ResultSet resultado = sql2.executeQuery();
                if(resultado.next()){
                    obj.setCodigo(resultado.getInt("codVenda"));
                }
                
               /*------- Salva o um item de venda ----------------------------*/ 
                for(ItemVenda it : obj.getItensVenda())
                {
                    SalvarItemVenda(it.getProduto(), obj, it);
                }
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        else 
        {
            try 
            {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Vendas set valorTotal=?, Data=?, codPessoa = ? where codVenda=?");
                sql.setDouble(1, obj.getValorTotal());
                sql.setDate(2, new java.sql.Date(obj.getData().getTime())); 
                sql.setInt(3, obj.getPessoa().getCodigo());
                sql.setInt(4, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    /*----------------------- Método Remover ---------------------------------*/
    public boolean Remover(Venda obj) 
    {
        if (obj.getCodigo() > 0) 
        {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from vendas where codVenda=?");
                sql.setInt(1, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;   
    }
    /*--------------------- Abrir --------------------------------------------*/

    public Venda Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Vendas where codVenda=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("codVenda"));                
                obj.setData(resultado.getDate("Data"));
                obj.setValorTotal(resultado.getDouble("ValorTotal"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    /*------------------- Listar ---------------------------------------------*/
    public List<Venda> ListarVendas() 
    {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Vendas");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {
                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("codVenda"));                
                obj.setData(resultado.getDate("Data"));
                obj.setValorTotal(resultado.getDouble("ValorTotal"));

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    /*------------------- Salva um item da venda -----------------------------*/
    private void SalvarItemVenda(Produto produto, Venda venda, ItemVenda obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into ItemVenda(codProduto,codVenda,quantidade) values(?,?,?)");
                sql.setInt(1, produto.getCodigo());
                sql.setInt(2, venda.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                
                sql.executeUpdate();
                
                obj.setCodigo(venda.getCodigo());
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        } 
        else {
            try{
                PreparedStatement sql = getConexao().prepareStatement("update ItemVenda set quantidade = ?, codProduto = ? where  codVenda = ?");
                sql.setInt(1, obj.getQuantidade());
                sql.setInt(2, produto.getCodigo());
                sql.setInt(3, obj.getCodigo());                
                sql.executeQuery();
                
                
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        }
    }
    
}

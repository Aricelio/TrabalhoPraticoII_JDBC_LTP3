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
                PreparedStatement sql = getConexao().prepareStatement("insert into vendas(valorTotal,data) values(?,?)");
                sql.setDouble(1, obj.getValorTotal());                
                sql.setDate(2, new java.sql.Date(obj.getData().getTime()));                
                sql.executeUpdate();
                
                
                PreparedStatement sql2 = getConexao().prepareStatement("select codVenda from Vendas where valorTotal = ? and Data = ?");
                sql2.setDouble(1, obj.getValorTotal());                
                sql2.setDate(2, new java.sql.Date(obj.getData().getTime())); 
                ResultSet resultado = sql2.executeQuery();
                if(resultado.next()){
                    obj.setCodigo(resultado.getInt("codVenda"));
                }
                
               /*------- Salva o email ---------------------------------------*/ 
                /*for(Email e : obj.getEmails())
                {
                    SalvarEmail(obj,e);
                }*/
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Vendas set valorTotal=?, Data=? where codVenda=?");
                sql.setDouble(1, obj.getValorTotal());
                sql.setDate(2, new java.sql.Date(obj.getData().getTime())); 
                sql.setInt(3, obj.getCodigo());
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
    
    
}

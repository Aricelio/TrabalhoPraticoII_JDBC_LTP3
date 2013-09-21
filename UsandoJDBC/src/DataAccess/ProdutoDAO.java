/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import DominModel.*; //Importando o Pacote DominModel
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alisson 02
 */
public class ProdutoDAO extends DAO{
    
    public ProdutoDAO(){
        super();
    }
    /*--------------------- Método Salvar ------------------------------------*/
    public boolean Salvar(Produto obj){
        if (obj.getCodigo() == 0) 
        {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into produtos(nome,tipo,preco) values(?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getTipo());
                sql.setDouble(3, obj.getPreco());
                sql.executeUpdate();
                
                
                PreparedStatement sql2 = getConexao().prepareStatement("select codProduto from Produtos where nome= ? and tipo = ? and preco=?");
                sql2.setString(1, obj.getNome());
                sql2.setString(2, obj.getTipo());
                sql2.setDouble(3, obj.getPreco());
                
                ResultSet resultado = sql2.executeQuery();
                
                if(resultado.next()){
                    obj.setCodigo(resultado.getInt("codProduto"));
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
                PreparedStatement sql = con.prepareStatement("update Produtos set Nome=?, tipo=? , preco=? where codProduto=?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getTipo());
                sql.setDouble(3, obj.getPreco());               
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
    public boolean Remover(Produto obj) 
    {
        if (obj.getCodigo() > 0) 
        {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from produtos where codProduto=?");
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


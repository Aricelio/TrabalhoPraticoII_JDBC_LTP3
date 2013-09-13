/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DominModel.*; //Importando o Pacote DominModel
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ALUNO
 */
public class PessoaDAO extends DAO {

    public PessoaDAO() {
        super();
    }
    /*--------------------- Método Salvar ------------------------------------*/

    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNascimento) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set Nome=?, DataNascimento=? where codPessoa=?");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
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

    public boolean Remover(Pessoa obj) 
    {
        if (obj.getCodigo() >= 0) 
        {
            try 
            {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
                sql.setInt(1, obj.getCodigo());
                //sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
                sql.executeUpdate();
                return true;

            } 
            catch (Exception ex) 
            {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
}

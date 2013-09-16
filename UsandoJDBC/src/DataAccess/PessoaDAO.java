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
                
               /*------- Salva o email ------------------*/ 
                for(Email e : obj.getEmails()){
                    SalvaEmail(obj,e);
                }

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

    public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
                sql.setInt(1, obj.getCodigo());
                //sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
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

    public Pessoa Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where codPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

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

    public List<Pessoa> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /*------------------------------------------------------------------------*/
    private void SalvarEmail(Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into emails(pessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        } 
        else {
            try{
                PreparedStatement sql = getConexao().prepareStatement("update emails set pessoa = ?, email = ? where id = ?");
                sql.setString(1,pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        }
    }
}

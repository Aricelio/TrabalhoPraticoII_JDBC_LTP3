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
                
                PreparedStatement sql2 = getConexao().prepareStatement("select codPessoa from pessoa where nome = ? and DataNascimento = ?");
                sql2.setString(1, obj.getNome());                
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if(resultado.next()){
                    obj.setCodigo(resultado.getInt("codPessoa"));
                }
                
               /*------- Salva o email ---------------------------------------*/ 
                for(Email e : obj.getEmails())
                {
                    SalvarEmail(obj,e);
                }
                /*------- Salva o Endereco -----------------------------------*/
                for(Endereco e : obj.getEnderecos())
                {
                    SalvarEndereco(obj,e);
                }
                /*------- Salva o Telefone -----------------------------------*/
                for(Telefone e : obj.getTelefones())
                {
                    SalvarTelefone(obj,e);
                }
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

    public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
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

    /*------------------ Salvar Email ----------------------------------------*/
    private void SalvarEmail(Pessoa pessoa, Email obj) {
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
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        }
    }
    /*------------------ Salvar Endereco ----------------------------------------*/
    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try 
            {
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(pessoa,numero,rua,bairro,cidade,uf,pais) values(?,?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());               
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getUf());
                sql.setString(7, obj.getPais());
                sql.executeUpdate();
            } 
            catch (Exception ex) 
            {
                System.err.println(ex.getMessage());                
            }
        } 
        else {
            try{
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set pessoa=?, numero=?, rua=?, bairro=?,cidade=?,uf=?,pais=? where id = ?");
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());               
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getUf());
                sql.setString(7, obj.getPais());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        }
    }
    /*------------------ Salvar Telefones ----------------------------------------*/
    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(pessoa,telefone,operadora,ddd) values(?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getOperadora());
                sql.setInt(4, obj.getDDD());
                sql.executeUpdate();

            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        } 
        else {
            try{
                PreparedStatement sql = getConexao().prepareStatement("update emails set pessoa = ?, telefone = ?, operadora = ?, ddd = ? where id = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getOperadora());
                sql.setInt(4, obj.getDDD());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } 
            catch (Exception ex) {
                System.err.println(ex.getMessage());                
            }
        }
    }
}

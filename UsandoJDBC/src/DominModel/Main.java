/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import DataAccess.*;
import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Pessoa pessoa = new Pessoa();
        
        //pessoa.setCodigo(3);
        //pessoa.setNome("Celi");
        //pessoa.setDataNascimento(new Date());
        
        //PessoaDAO dao = new PessoaDAO();
        
        //dao.Salvar(pessoa);  
        //dao.Remover(pessoa);
        /*pessoa = dao.Abrir(4);
        
        System.out.print("Codigo: ");
        System.out.println(pessoa.getCodigo());
        
        System.out.print("Nome: ");
        System.out.println(pessoa.getNome());
        
        System.out.print("Data de Nascimento: ");
        System.out.println(pessoa.getDataNascimento());*/
        Pessoa p = new Pessoa();
        
        Email e = new Email();
        Email f = new Email();
        
        Telefone t = new Telefone();
        Telefone te = new Telefone();
        
        Endereco en = new Endereco();
        Endereco end = new Endereco();
        
        e.setEmail("ariceliosouza@hotmail.com");
        f.setEmail("ariceliodesouza@gmail.com");
        
        t.setTelefone(36135000);
        t.setDDD((byte)38);
        t.setOperadora((byte)011);        
        
        te.setTelefone(36134000);
        te.setDDD((byte)39);
        te.setOperadora((byte)012);
        
        en.setNumero(98);
        en.setRua("Rua Coronel Serrão");
        en.setBairro("São José");
        en.setCidade("Itacarambi");
        en.setUf("MG");
        en.setPais("Brasil");
        
        end.setNumero(300);
        end.setRua("Rua das Flores");
        en.setBairro("Centro");
        en.setCidade("Januaria");
        en.setUf("MG");
        en.setPais("Brasil");
        
        p.setNome("Philipe Souza");
        
        p.setDataNascimento(new Date());
        
        p.addEmail(e);
        p.addEmail(f);
        p.addTelefone(t);
        p.addTelefone(te);
        p.addEndereco(en);
        p.addEndereco(end);
        
        
        
        PessoaDAO dao = new PessoaDAO();
        dao.Salvar(p);
    }
}


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
        
        PessoaDAO dao = new PessoaDAO();
        
        //dao.Salvar(pessoa);  
        //dao.Remover(pessoa);
        pessoa = dao.Abrir(4);
        
        System.out.print("Codigo: ");
        System.out.println(pessoa.getCodigo());
        
        System.out.print("Nome: ");
        System.out.println(pessoa.getNome());
        
        System.out.print("Data de Nascimento: ");
        System.out.println(pessoa.getDataNascimento());
    }
}

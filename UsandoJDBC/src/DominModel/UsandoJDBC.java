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
public class UsandoJDBC 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome("Celi Fiuza de Souza Fernandes");
        pessoa.setDataNascimento(new Date());
        
        PessoaDAO dao = new PessoaDAO();
        
        dao.Salvar(pessoa);        
    }
}


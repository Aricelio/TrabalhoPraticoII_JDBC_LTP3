/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class Pessoa {

    private String nome;
    private int codigo;
    private Date DataNascimento;

    /*---------- Construtor --------------------------------------------------*/
    public Pessoa() {
        codigo = 0;
    }

    /*---------- Getters e Setters -------------------------------------------*/
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public Date getDataNascimento() 
    {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) 
    {
        this.DataNascimento = DataNascimento;
    }

    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        if(codigo >= 0)
            this.codigo = codigo;
    }
}

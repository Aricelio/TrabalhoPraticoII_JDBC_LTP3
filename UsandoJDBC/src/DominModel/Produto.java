/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alisson 02
 */
public class Produto {
    private int codigo;
    private String nome;
    private String tipo;
    private double preco;
    
    /*-------- Getters--------------------------------------------------------*/
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    /*-------- Setters--------------------------------------------------------*/
    public void setCodigo(int codigo) throws Exception
    {
        if(codigo >= 1)
            this.codigo = codigo;
        else{
            throw new Exception("Valor passado para o campo 'Codigo' é invalido!Valor menor que 1");
        }
    }

    public void setNome(String nome)throws Exception 
    {
        Pattern Nome = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);
        
        if(verifica.matches())
            this.nome = nome;
        else{
            throw new Exception("Valor passado para o campo 'Nome' é invalido!");
        }
    }

    public void setTipo(String tipo) throws Exception
    {
        Pattern Tipo = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Tipo.matcher(tipo);
        
        if(verifica.matches())
            this.tipo = tipo;
        else{
            throw new Exception("Valor passado para o campo 'Tipo' é invalido!");
        }
    }
    public void setPreco(double preco)throws Exception 
    {        
        if(preco >= 1)
            this.preco = preco;
        else{
            throw new Exception("Valor passado para o campo 'Preoc' é invalido!Valor menor que 1");
        }
    }
}

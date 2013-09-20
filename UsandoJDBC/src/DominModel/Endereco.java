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
public class Endereco 
{
    private int codigo;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
    
 
    /*------- Métodos Getters-----------*/   
    public int getCodigo() {
        return codigo;
    }

    public int getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getPais() {
        return pais;
    }

    /*----------Métodos Setters------------------------------*/
    public void setCodigo(int codigo) throws Exception{
       if(codigo >= 1)
         this.codigo = codigo;
       else{
         throw new Exception("Codigo Invalido!");
       }
    }
    
    public void setNumero(int numero) throws Exception
    {        
         if(numero >= 1)
            this.numero = numero; 
         else{
            throw new Exception("Valor passado para o campo 'Numero' é Invalido!");
         }
    }

    public void setRua(String rua) throws Exception
    {        
        Pattern Rua = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Rua.matcher(rua);
        
        if(verifica.matches())
            this.rua = rua;   
        else{
            throw new Exception("Valor passado para o campo 'Rua' é Invalido!");
         }
    }

    public void setBairro(String bairro)  throws Exception
    {        
        Pattern Bairro = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Bairro.matcher(bairro);
        
        if(verifica.matches())        
             this.bairro = bairro;
        else{
            throw new Exception("Valor passado para o campo 'Bairro' é Invalido!");
         }
    }

    public void setCidade(String cidade) throws Exception 
    {
        Pattern Cidade = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Cidade.matcher(cidade);
        
        if(verifica.matches())
             this.cidade = cidade;
        else{
            throw new Exception("Valor passado para o campo 'Cidade' é Invalido!");
         }
    }

    public void setUf(String uf)throws Exception  
    {
        Pattern UF = Pattern.compile("\\w*{2,}");
        Matcher verifica = UF.matcher(uf);
        
        if(verifica.matches())
             this.uf = uf;
        else{
            throw new Exception("Valor passado para o campo 'UF' é Invalido!");
         }
    }

    public void setPais(String pais)throws Exception
    {
        Pattern Pais = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Pais.matcher(pais);
        
        if(verifica.matches())
             this.pais = pais;
        else{
            throw new Exception("Valor passado para o campo 'Pais' é Invalido!");
        }
    }
 
}
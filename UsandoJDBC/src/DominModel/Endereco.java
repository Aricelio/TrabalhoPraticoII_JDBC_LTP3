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
    public void setCodigo(int codigo) {
       if(codigo >= 1)
         this.codigo = codigo;
    }
    
    public void setNumero(int numero) 
    {
        
         if(numero >= 1)
            this.numero = numero;        
    }

    public void setRua(String rua) 
    {        
        Pattern Rua = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Rua.matcher(rua);
        
        if(verifica.matches())
            this.rua = rua;        
    }

    public void setBairro(String bairro) 
    {        
        Pattern Bairro = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Bairro.matcher(bairro);
        
        if(verifica.matches())        
             this.bairro = bairro;
    }

    public void setCidade(String cidade) 
    {
        Pattern Cidade = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Cidade.matcher(cidade);
        
        if(verifica.matches())
             this.cidade = cidade;
    }

    public void setUf(String uf) 
    {
        Pattern UF = Pattern.compile("[a-zA-Z]{2}");
        Matcher verifica = UF.matcher(uf);
        
        if(verifica.matches())
             this.uf = uf;
    }

    public void setPais(String pais) 
    {
        Pattern Pais = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Pais.matcher(pais);
        
        if(verifica.matches())
             this.pais = pais;
    }
 
}
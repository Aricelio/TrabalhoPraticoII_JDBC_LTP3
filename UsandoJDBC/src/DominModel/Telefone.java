/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alisson 02
 */
public class Telefone 
{
    private int codigo;
    private int telefone;
    private byte ddd;
    private byte operadora;
    
    /*------ Getters ---------------------------------------------------------*/
    public int getTelefone(){
        return telefone;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public byte getDDD(){
        return ddd;
    }
    
    public byte getOperadora(){
        return operadora;
    }
    
    /*-------- Setters ------------------------------------------------------ */
    public void setCodigo(int codigo) 
    { 
        if(codigo >= 1)
            this.codigo = codigo;
    }
    
    public void setDDD(byte ddd){
        if((ddd > 9) && (ddd < 100)){
            this.ddd = ddd;
        }
    }
    
    public void setOperadora(byte operadora){
        if((operadora > 9) && (operadora < 100)){
            this.operadora = operadora;
        }
    }
    
    public void setTelefone(int telefone)
    {
        if(telefone > 11111111)
            this.telefone = telefone;
    }    
}

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
public class ItemVenda 
{
    private int codigo;
    private int quantidade;
    private Produto produto;

    
   /*-------- Getters---------------------------------------------------------*/ 
    public Produto getProduto(){
        return this.produto;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public int getQuantidade() 
    {
        return quantidade;
    }

    public double getValorTotalItem() 
    {
        double total =  getQuantidade() * produto.getPreco();
        return total;
    }
    /*-------- Setters--------------------------------------------------------*/
    public void setCodigo(int codigo)throws Exception
    {
       if(codigo >= 1)
         this.codigo = codigo;
       else{
         throw new Exception("Valor passado para o campo 'Codigo' é invalido!");
       }
    }
     
    public void setQuantidade(int quantidade)throws Exception 
    {
        if(quantidade >= 1)
              this.quantidade = quantidade;
        else{
         throw new Exception("Quantidade inferior á 1!");
        }
    }
     
    public void setProduto(Produto produto)throws Exception
    {
        if(produto != null)
            this.produto = produto;
        else{
         throw new Exception("Valor passado para o campo 'Produto' é Nulo!");
        }
    }
}



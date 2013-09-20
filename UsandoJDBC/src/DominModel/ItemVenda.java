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
     public void setCodigo(int codigo) {
       if(codigo >= 1)
         this.codigo = codigo;
    }
     
    public void setQuantidade(int quantidade) 
    {
        if(quantidade >= 1)
              this.quantidade = quantidade;
    }
     
    public void setProduto(Produto produto)
    {
        if(produto != null)
            this.produto = produto;
    }
}



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alisson 02
 */
public class Venda {
    
    private int codigo;
    private Date data;
    private double valorTotal;
    private Pessoa pessoa;
    private List<ItemVenda> itensVenda;
    
  /*---------Construtor --------------------------*/ 
    public Venda(){
        itensVenda = new ArrayList<ItemVenda>();
        this.codigo = 0;
        
    }
  /*-------Getter-------------------------------------------------------------*/
    public int getCodigo() {
        return codigo;
    }
    
    public Date getData() {
        return data;
    }
    
    public double getValorTotal() {        
        return valorTotal;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }
    
    
   /*-------- Setters---------------------------------------------------------*/
    public void setCodigo(int codigo) throws Exception
    {
        if(codigo >= 1)
            this.codigo = codigo;
        else{
         throw new Exception("Codigo Invalido!");
       }
    }
    
    public void setData(Date data)throws Exception
    {       
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1800,1,1);
        
        if(calendario.getTime().after(data))
              this.data = data;
        else{
         throw new Exception("Data Invalida!");
       }
    }
    
    private void setValorTotal(double valor)throws Exception
    {
        if(valor > 1)
             this.valorTotal = valor;
        else{
         throw new Exception("Valor Invalido!");
       }
    }
    
    public void setPessoa(Pessoa pessoa)throws Exception
    {
        if(pessoa != null){
            this.pessoa = pessoa;
        }
        else{
         throw new Exception("Valor passado para o campo 'Pessoa' é Nulo!");
       }
    }
    
  /*--------------- Adiciona umm item á venda --------------------------------*/  
    public void addItemVenda(ItemVenda itemVenda) throws Exception{
        if(!itensVenda.contains(itemVenda)){
            itensVenda.add(itemVenda);
            
            double valor = itemVenda.getValorTotalItem() + getValorTotal();
            setValorTotal(valor);
        }
    }
  /*--------------- Remove um item da Venda-----------------------------------*/  
    public void removeItemVenda(ItemVenda itemVenda) throws Exception{
        if(itensVenda.contains(itemVenda)){
            itensVenda.remove(itemVenda);
            
            double valor = getValorTotal() - itemVenda.getValorTotalItem();
            setValorTotal(valor);
        }
    }

   
}

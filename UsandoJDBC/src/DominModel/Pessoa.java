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
 * @author ALUNO
 */
public class Pessoa {

    private String nome;
    private int codigo;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    /*---------- Construtor --------------------------------------------------*/
    public Pessoa() {
        codigo = 0;
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
        telefones = new ArrayList<Telefone>();
    }

    /*---------- Getters e Setters -------------------------------------------*/
    /*---------------------- Nome --------------------------------------------*/
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);
        
        if(verifica.matches())
              this.nome = nome;
    }
    /*--------------------- Data de Nascimento -------------------------------*/
    public Date getDataNascimento() 
    {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) 
    {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900,1,1);
        
        if(calendario.getTime().before(DataNascimento))
             this.DataNascimento = DataNascimento;
    }
    /*--------------------- Codigo -------------------------------------------*/
    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        if(codigo >= 0)
            this.codigo = codigo;
    }

    /*----------- Adicionar email---------------------------------------------*/  
    public void addEmail(Email email){
        if(!emails.contains(email)){
            emails.add(email);
        }
    }
   /*-----------Remover Email-------------------------------------------------*/
    public void removeEmail(Email email){
        if(emails.contains(email)){
            emails.remove(email);
        }
    } 
    /*----------- Retorna a lista de emails ----------------------------------*/
    public List<Email> getEmails(){
        return emails;
    }
    
    /*----------- Adiciona um Endereco ---------------------------------------*/
     public void addEndereco(Endereco endereco){
        if(!enderecos.contains(endereco)){
            enderecos.add(endereco);
        }
    }
    /*----------- Remove um Endereco -----------------------------------------*/
     public void removeEndereco(Endereco endereco){
        if(enderecos.contains(endereco)){
            enderecos.remove(endereco);
        }
    } 
    /*----------- Retorna a lista de Enderecos--------------------------------*/
    public List<Endereco> getEnderecos(){
        return enderecos;
    }
      /*-----------Adicionar um Telefone----------*/ 
    public void addTelefone(Telefone telefone)
    {
        if(!telefones.contains(telefone)){
            telefones.add(telefone);
        }
    }
    /*----------Remove uma Telefone----------------*/ 
    public void removeTelefone(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    } 
    /*--------- Retorna a lista de telefones ---------------------------------*/
    public List<Telefone> getTelefones(){
        return telefones;
    }
    /*----------------- hashCode ---------------------------------------------*/
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.codigo;
        hash = 43 * hash + Objects.hashCode(this.DataNascimento);
        return hash;
    }
    /*----------------- Equals -----------------------------------------------*/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        return true;
    }    
}

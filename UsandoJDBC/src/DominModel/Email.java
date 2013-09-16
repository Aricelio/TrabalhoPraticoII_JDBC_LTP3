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
public class Email 
{
    private int codigo;
    private String email;

  /*--------Métodos Getters e Setters------------*/
    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setCodigo(int codigo) {
       if(codigo >= 1)
         this.codigo = codigo;
    }

    public void setEmail(String email) 
    {
        Pattern emailP = Pattern.compile("[a-zA-Z0-9\\-_.]{3,250}@[\\d\\w]+.[\\w.]+");
        Matcher verifica = emailP.matcher(email);
        
        if(verifica.matches())
            this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "codigo=" + codigo + ", email=" + email + '}';
    }   
}


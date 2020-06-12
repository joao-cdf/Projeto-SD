package dev.controller;

// Manages sign_in and sign_out

import dev.bean.UtilizadorBean;
import dev.entities.Utilizador;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="Logging")
@SessionScoped
public class Logging implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String email;
    private String password;
    private boolean logged;
    
    @EJB
    private UtilizadorBean user;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    
    
    public String sign_in()   {
        String result = "";
        Utilizador Unew = user.findUtilizador(email);
        if (Unew != null)   {
            if(this.password.equals(Unew.getPassword()))    {
                this.setLogged(true);
                this.setNome(Unew.getNome());                
                result = "success";
            }
            else    {
                result = "failure";
            }
        }        
        else
            result = "failure";
        return result;
    }
    
    public String sign_out()  {
        this.setLogged(false);
        this.setNome(null);          
        return "index.xhtml";
    }

}

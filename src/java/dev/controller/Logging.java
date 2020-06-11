package dev.controller;

// Manages sign_in and sign_out

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="Logging")
@SessionScoped
public class Logging implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String email;
    private String password;
    

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
    
    public String sign_in()   {
        return "";
    }
    
    public String sign_out()  {
        return "";
    }
    
    
    
}

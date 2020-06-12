package dev.controller;

import dev.bean.UtilizadorBean;
import dev.entities.Utilizador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="Register")
@RequestScoped
public class Register implements Serializable   {
    
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
   
    @EJB
    private UtilizadorBean user;
    List<Utilizador> userList = new ArrayList<>();
    public List<Utilizador> getUserList()   {
        userList = user.getUtilizadores();
        return userList;
    }
    
    public String addUtilizador()   {
        Utilizador x = new Utilizador();
        x.setNome(nome);
        x.setEmail(email);
        x.setPassword(password);
        
        user.addUtilizador(x);
        return "sign_in.xhtml";        
    }
    
}

package dev.controller;

import dev.bean.MobiliBean;
import dev.entities.Mobiliarioclinico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named (value = "mobiliController")
@RequestScoped
public class MobiliController implements Serializable{
    
    private int id;
    private String nome;
    private String descricao;
    private int qtd_total;
    private int qtd_disp;
    private int selected_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd_total() {
        return qtd_total;
    }

    public void setQtd_total(int qtd_total) {
        this.qtd_total = qtd_total;
    }

    public int getQtd_disp() {
        return qtd_disp;
    }

    public void setQtd_disp(int qtd_disp) {
        this.qtd_disp = qtd_disp;
    }
    
    @EJB
    private MobiliBean mobiliBean;
    List<Mobiliarioclinico> productList = new ArrayList<>();
    public List<Mobiliarioclinico> getProductList() {
        
        productList = mobiliBean.getProducts();
        return productList;
    }
    
    public String addProduct()  {
        Mobiliarioclinico x = new Mobiliarioclinico();
        x.setNome(nome);
        x.setDescricao(descricao);
        x.setQuantidadeTotal(qtd_total);
        x.setQuantidadeDisponivel(qtd_total);
        
        mobiliBean.addProduct(x);
        return "listar_todos_mobiclin.xhtml";
    }
    
    public void set_selected_id()   {
        
    }
    
    public Mobiliarioclinico getProduct()   {
        return mobiliBean.getProduct(selected_id);
    }
    
}

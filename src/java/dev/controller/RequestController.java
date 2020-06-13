package dev.controller;

import dev.bean.RequestProductBean;
import dev.entities.Requisicao;
import dev.entities.Reserva;
import dev.entities.Utilizador;
import dev.entities.Mobiliarioclinico;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named (value = "requestController")
@RequestScoped
public class RequestController implements Serializable{
    private String d_temp_date;
    private int i_qtd;
    private int i_id_produto;
    private int i_id_user;

    public String getD_temp_date() {
        return d_temp_date;
    }

    public void setD_temp_date(String d_temp_date) {
        this.d_temp_date = d_temp_date;
    }

    public int getI_qtd() {
        return i_qtd;
    }

    public void setI_qtd(int i_qtd) {
        this.i_qtd = i_qtd;
    }

    public int getI_id_produto() {
        return i_id_produto;
    }

    public void setI_id_produto(int i_id_produto) {
        this.i_id_produto = i_id_produto;
    }

    public int getI_id_user() {
        return i_id_user;
    }

    public void setI_id_user(int i_id_user) {
        this.i_id_user = i_id_user;
    }

    public RequestProductBean getRequestProductBean() {
        return requestProductBean;
    }

    public void setRequestProductBean(RequestProductBean requestProductBean) {
        this.requestProductBean = requestProductBean;
    }
    
    @EJB
    private RequestProductBean requestProductBean;
    public String addNewRequ_Resv() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;
        try {
            dataFormatada = formato.parse(d_temp_date);
        } catch (ParseException ex) {
            Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Utilizador o_user = new Utilizador();
        Requisicao o_requisa = new Requisicao();
        Reserva o_reserva = new Reserva();
        Mobiliarioclinico o_m_b = new Mobiliarioclinico();

        o_user.setIdUtilizador(i_id_user);
        //dado id do produto obter informacao do mesmo
        o_m_b=requestProductBean.getProduct(i_id_produto);
        // se a quantidade inserida no input é maior que a quantidade disponivel -> reserva
        if (i_qtd > o_m_b.getQuantidadeDisponivel()) {
//            o_reserva.setQuantidadeReservada(i_qtd);
//            o_reserva.setDataReserva(dataFormatada);
//            o_reserva.setIdUtilizador(o_user);  
//            o_reserva.setIdProduto(o_m_b);
//            requestProductBean.add_res(o_reserva);
//            //reserva
        }
        else{
            o_requisa.setQuantidadeRequisitada(i_qtd);
            o_requisa.setDataRequisicao(dataFormatada);
            o_requisa.setIdUtilizador(o_user);
            o_requisa.setIdProduto(o_m_b);
            requestProductBean.add_req(o_requisa);
            //requisicao
        }
        return "index.xhtml";
        
    }
}

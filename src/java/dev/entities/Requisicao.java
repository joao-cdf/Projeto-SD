/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joaof
 */
@Entity
@Table(name = "REQUISICAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisicao.findAll", query = "SELECT r FROM Requisicao r")
    , @NamedQuery(name = "Requisicao.findByIdRequisicao", query = "SELECT r FROM Requisicao r WHERE r.idRequisicao = :idRequisicao")
    , @NamedQuery(name = "Requisicao.findByDataRequisicao", query = "SELECT r FROM Requisicao r WHERE r.dataRequisicao = :dataRequisicao")
    , @NamedQuery(name = "Requisicao.findByQuantidadeRequisitada", query = "SELECT r FROM Requisicao r WHERE r.quantidadeRequisitada = :quantidadeRequisitada")})
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REQUISICAO")
    private Integer idRequisicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_REQUISICAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRequisicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE_REQUISITADA")
    private int quantidadeRequisitada;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne(optional = false)
    private Mobiliarioclinico idProduto;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public Requisicao() {
    }

    public Requisicao(Integer idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public Requisicao(Integer idRequisicao, Date dataRequisicao, int quantidadeRequisitada) {
        this.idRequisicao = idRequisicao;
        this.dataRequisicao = dataRequisicao;
        this.quantidadeRequisitada = quantidadeRequisitada;
    }

    public Integer getIdRequisicao() {
        return idRequisicao;
    }

    public void setIdRequisicao(Integer idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public int getQuantidadeRequisitada() {
        return quantidadeRequisitada;
    }

    public void setQuantidadeRequisitada(int quantidadeRequisitada) {
        this.quantidadeRequisitada = quantidadeRequisitada;
    }

    public Mobiliarioclinico getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Mobiliarioclinico idProduto) {
        this.idProduto = idProduto;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisicao != null ? idRequisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.idRequisicao == null && other.idRequisicao != null) || (this.idRequisicao != null && !this.idRequisicao.equals(other.idRequisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.entities.Requisicao[ idRequisicao=" + idRequisicao + " ]";
    }
    
}

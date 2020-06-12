package dev.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xt
 */
@Entity
@Table(name = "MOBILIARIOCLINICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobiliarioclinico.findAll", query = "SELECT m FROM Mobiliarioclinico m")
    , @NamedQuery(name = "Mobiliarioclinico.findByIdProduto", query = "SELECT m FROM Mobiliarioclinico m WHERE m.idProduto = :idProduto")
    , @NamedQuery(name = "Mobiliarioclinico.findByNome", query = "SELECT m FROM Mobiliarioclinico m WHERE m.nome = :nome")
    , @NamedQuery(name = "Mobiliarioclinico.findByDescricao", query = "SELECT m FROM Mobiliarioclinico m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Mobiliarioclinico.findByQuantidadeTotal", query = "SELECT m FROM Mobiliarioclinico m WHERE m.quantidadeTotal = :quantidadeTotal")
    , @NamedQuery(name = "Mobiliarioclinico.findByQuantidadeDisponivel", query = "SELECT m FROM Mobiliarioclinico m WHERE m.quantidadeDisponivel = :quantidadeDisponivel")})
public class Mobiliarioclinico implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE_TOTAL")
    private int quantidadeTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE_DISPONIVEL")
    private int quantidadeDisponivel;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private Integer idProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private Collection<Requisicao> requisicaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private Collection<Reserva> reservaCollection;

    public Mobiliarioclinico() {
    }

    public Mobiliarioclinico(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Mobiliarioclinico(Integer idProduto, String nome, int quantidadeTotal, int quantidadeDisponivel) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }


    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @XmlTransient
    public Collection<Requisicao> getRequisicaoCollection() {
        return requisicaoCollection;
    }

    public void setRequisicaoCollection(Collection<Requisicao> requisicaoCollection) {
        this.requisicaoCollection = requisicaoCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobiliarioclinico)) {
            return false;
        }
        Mobiliarioclinico other = (Mobiliarioclinico) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mobiliarioclinico{" + "idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", quantidadeTotal=" + quantidadeTotal + ", quantidadeDisponivel=" + quantidadeDisponivel + ", requisicaoCollection=" + requisicaoCollection + ", reservaCollection=" + reservaCollection + '}';
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
}

package dev.bean;


import dev.entities.Mobiliarioclinico;
import dev.entities.Requisicao;
import dev.entities.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RequestProductBean {

    @PersistenceContext(unitName = "project_sdPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Mobiliarioclinico getProduct(int id_produto) {
        return (Mobiliarioclinico) em.createNamedQuery("Mobiliarioclinico.findByIdProduto").setParameter("idProduto", id_produto).getSingleResult();
    }

    public Requisicao add_req(Requisicao x)   {
        em.persist(x);
        return x;
    }
//    public Reserva add_res(Reserva x)   {
//        em.persist(x);
//        return x;
//    }
    

    public void persist1(Object object) {
        em.persist(object);
    }
    
}

package dev.bean;

import dev.entities.Mobiliarioclinico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xt
 */
@Stateless
public class MobiliBean {

    @PersistenceContext(unitName = "project_sdPU")
    private EntityManager em;

    public List<Mobiliarioclinico> getProducts() {
        return (List<Mobiliarioclinico>) em.createNamedQuery("Mobiliarioclinico.findAll").getResultList();
    }
    
    public Mobiliarioclinico addProduct(Mobiliarioclinico x)    {
        em.persist(x);
        return x;
    }
    
}

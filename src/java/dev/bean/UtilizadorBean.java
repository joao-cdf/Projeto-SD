package dev.bean;

import dev.entities.Utilizador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UtilizadorBean {
    
    @PersistenceContext(unitName = "project_sdPU")
    private EntityManager em;
    
    public Utilizador findUtilizador(String email) {
            //int aux = em.createNamedQuery("Utilizador.findByEmail").setParameter("email", email).getFirstResult();
            //if (aux == 1)
                return (Utilizador)em.createNamedQuery("Utilizador.findByEmail").setParameter("email", email).getSingleResult();
            //else    
            //    return null;
    }
    
    public List<Utilizador> getUtilizadores()   {
        return (List<Utilizador>)em.createNamedQuery("Utilizador.findAll").getResultList();
    }
    
    public Utilizador addUtilizador(Utilizador x)   {
        em.persist(x);
        return x;
    }
}


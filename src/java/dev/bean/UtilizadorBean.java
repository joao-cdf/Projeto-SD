package dev.bean;

import dev.entities.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UtilizadorBean {
    
    @PersistenceContext(unitName = "project_sdPU")
    private EntityManager em;
    
    public List<Utilizador> getUtilizadores()   {
        return (List<Utilizador>)em.createNamedQuery("Utilizador.findAll").getResultList();
    }
    
    public Utilizador addUtilizador(Utilizador x)   {
        em.persist(x);
        return x;
    }
}


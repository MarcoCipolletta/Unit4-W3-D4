package it.epicode.dao;

import it.epicode.entity.Partecipation;
import jakarta.persistence.EntityManager;

public class PartecipationDAO {
    private EntityManager em;

    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipation partecipation) {
        em.persist(partecipation);
    }

    public Partecipation getById(long id) {
        return em.find(Partecipation.class, id);
    }

    public void delete(Partecipation partecipation) {
        em.remove(partecipation);
    }
}

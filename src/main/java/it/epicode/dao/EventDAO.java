package it.epicode.dao;

import it.epicode.entity.Concerto;
import it.epicode.entity.Event;

import it.epicode.entity.PartitaDiCalcio;
import it.epicode.enums.Genere;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventDAO {
    private EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
    }

    public Event getById(long id) {
        return em.find(Event.class, id);
    }

    public void delete(Event event) {
        em.getTransaction().begin();
        em.remove(event);
        em.getTransaction().commit();
    }

    public List<Concerto> getConcertInStreaming(Boolean inStreaming) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class).setParameter("inStreaming", inStreaming).getResultList();
    }

    public List<Concerto> getConcertByGenere(Genere genere) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class).setParameter("genere", genere).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        return em.createNamedQuery("Trova_partite_vinte_in_casa", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInOspite(){
        return em.createNamedQuery("Trova_partite_vinte_in_ospite", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate(){
        return em.createNamedQuery("Trova_partite_pareggiate", PartitaDiCalcio.class).getResultList();
    }
}

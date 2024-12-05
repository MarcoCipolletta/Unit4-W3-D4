package it.epicode.dao;

import it.epicode.entity.Person;
import jakarta.persistence.EntityManager;

public class PersonDAO {
    private EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        em.persist(person);
    }

    public Person getById(long id) {
        return em.find(Person.class, id);
    }

    public void delete(Person person) {
        em.remove(person);
    }
}

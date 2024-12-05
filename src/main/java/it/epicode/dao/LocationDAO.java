package it.epicode.dao;

import it.epicode.entity.Location;
import jakarta.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        em.persist(location);
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location location) {
        em.remove(location);
    }
}

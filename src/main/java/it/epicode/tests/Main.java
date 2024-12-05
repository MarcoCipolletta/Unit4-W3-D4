package it.epicode.tests;

import com.github.javafaker.Faker;
import it.epicode.dao.EventDAO;
import it.epicode.entity.Concerto;
import it.epicode.entity.Event;
import it.epicode.entity.PartitaDiCalcio;
import it.epicode.enums.Genere;
import it.epicode.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();
        EventDAO eventDAO = new EventDAO(em);


        for (int i = 0; i < 100; i++) {
            Concerto concert = new Concerto();
            concert.setGenere(faker.options().option(Genere.class));
            concert.setInStreaming(faker.bool().bool());
            concert.setTitle(faker.book().title());
            eventDAO.save(concert);
        }

        for (int i = 0; i < 100; i++) {
        PartitaDiCalcio partita = new PartitaDiCalcio();
        partita.setSquadraDiCasa(faker.team().name());
        partita.setSquadraOspite(faker.team().name());

        partita.setGoalSquadraDiCasa(faker.number().numberBetween(0, 5));
        partita.setGoalSquadraOspite(faker.number().numberBetween(0, 5));
        if (partita.getGoalSquadraDiCasa() > partita.getGoalSquadraOspite()) {
            partita.setSquadraVincitore(partita.getSquadraDiCasa());
        } else if (partita.getGoalSquadraDiCasa() < partita.getGoalSquadraOspite()) {
            partita.setSquadraVincitore(partita.getSquadraOspite());
        } else {
            partita.setSquadraVincitore(null);
        }
        eventDAO.save(partita);

        }








        em.close();
        emf.close();
    }
}
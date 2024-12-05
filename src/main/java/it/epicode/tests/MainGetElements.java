package it.epicode.tests;

import it.epicode.dao.EventDAO;
import it.epicode.enums.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGetElements {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        EventDAO eventDAO = new EventDAO(em);
        System.out.println("Concerti in streaming:");
        System.out.println(eventDAO.getConcertInStreaming(true));

        System.out.println("Concerti Rock");
        System.out.println(eventDAO.getConcertByGenere(Genere.ROCK));

        System.out.println("Parite vinte in casa");
        System.out.println(eventDAO.getPartiteVinteInCasa());

        System.out.println("Partite vinte in trasferta");
        System.out.println(eventDAO.getPartiteVinteInOspite());

        System.out.println("Partite pareggiate");
        System.out.println(eventDAO.getPartitePareggiate());

    }

}

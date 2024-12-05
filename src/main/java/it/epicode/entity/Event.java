package it.epicode.entity;


import it.epicode.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Column(name = "date_event")
    private Date dateEvent;
    private String description;
    @Column(name="tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name="max_number_of_participants", nullable = false)
    private int maxNumberOfParticipants;

    @ManyToOne//(mappedBy = "event")
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event")

    private List<Partecipation> partecipations  = new ArrayList<>();

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + title + '\'' +
                ", dataEvento=" + dateEvent +
                ", descrizione='" + description + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + maxNumberOfParticipants +
                ", location=" + location +
                '}';
    }

}

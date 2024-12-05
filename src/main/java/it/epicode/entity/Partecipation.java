package it.epicode.entity;


import it.epicode.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;

@Data
@Entity
@Table(name = "partecipations")
public class Partecipation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + person +
                ", evento=" + event +
                ", stato=" + status +
                '}';
    }
}

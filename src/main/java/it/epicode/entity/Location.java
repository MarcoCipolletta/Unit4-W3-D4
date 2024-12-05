package it.epicode.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String city;
//    @OneToOne( fetch = FetchType.LAZY)
//    @JoinColumn(name = "event_id")
//    private Event event;

    @Override
    public String toString() {
        return "Location [id=" + id + ", nome=" + name + ", citta=" + city + "]";
    }
}

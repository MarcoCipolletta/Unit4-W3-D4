package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class GaraDiAtletica extends Event {
    @OneToMany
    List<Person> athletes;
    @OneToOne
    Person winner;
}

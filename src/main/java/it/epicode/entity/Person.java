package it.epicode.entity;


import it.epicode.enums.Sex;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;
    private String email;
    @Column(name = "birth_date")
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @OneToMany (mappedBy = "person")
    private List<Partecipation> partecipations = new ArrayList<>();

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", cognome='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + birthDate +
                ", sesso=" + sex +
                '}';
    }

}

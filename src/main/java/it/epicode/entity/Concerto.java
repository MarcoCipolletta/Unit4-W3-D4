package it.epicode.entity;

import it.epicode.enums.Genere;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "concerti")
public class Concerto  extends Event{
@Enumerated(EnumType.STRING)
Genere genere;
@Column(name = "in_streaming")
Boolean inStreaming;
}

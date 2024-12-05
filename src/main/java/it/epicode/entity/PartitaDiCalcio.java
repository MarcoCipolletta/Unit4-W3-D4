package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name="Trova_partite_vinte_in_casa", query="SELECT a FROM PartitaDiCalcio a WHERE a.goalSquadraDiCasa > a.goalSquadraOspite")
@NamedQuery(name="Trova_partite_vinte_in_ospite", query="SELECT a FROM PartitaDiCalcio a WHERE a.goalSquadraDiCasa < a.goalSquadraOspite")
@NamedQuery(name="Trova_partite_pareggiate", query="SELECT a FROM PartitaDiCalcio a WHERE a.goalSquadraDiCasa = a.goalSquadraOspite")

public class PartitaDiCalcio extends Event {
    @Column(name = "squadra_di_casa")
   String squadraDiCasa;
   @Column(name = "squadra_ospite")
   String squadraOspite;
   @Column(name = "squadra_vincitore")
   String squadraVincitore;
   @Column(name = "goal_squadra_di_casa")
   int goalSquadraDiCasa;
   @Column(name = "goal_squadra_ospite")
   int goalSquadraOspite;


}

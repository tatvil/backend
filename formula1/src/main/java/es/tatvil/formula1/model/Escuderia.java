package es.tatvil.formula1.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "escuderias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Escuderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String pais;
    private String motor;

    @OneToMany(mappedBy = "escuderia")
    private List<PilotoEscuderia> pilotosEscuderia;
	}

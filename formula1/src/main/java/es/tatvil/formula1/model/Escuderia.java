package es.tatvil.formula1.model;

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

	}

/*
> DESC escuderias;
| id     | int(11)      | NO   | PRI | NULL    | auto_increment |
| nombre | varchar(150) | NO   |     | NULL    |                |
| pais   | varchar(100) | YES  |     | NULL    |                |
| motor  | varchar(100) | YES  |     | NULL    |                |
*/
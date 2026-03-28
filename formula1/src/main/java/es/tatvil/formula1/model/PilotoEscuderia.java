package es.tatvil.formula1.model;

import jakarta.persistence.*;

@Entity
public class PilotoEscuderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Piloto piloto;

    @ManyToOne
    private Escuderia escuderia;

    // GETTER para Piloto
    public Piloto getPiloto() {
        return piloto;
    }

    // SETTER opcional
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    // GETTER para Escuderia
    public Escuderia getEscuderia() {
        return escuderia;
    }

    // SETTER opcional
    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }
}
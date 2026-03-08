package es.tatvil.formula1.repository;

import es.tatvil.formula1.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<Piloto, Integer> {
}
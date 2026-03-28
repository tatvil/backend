package es.tatvil.formula1.repository;

import es.tatvil.formula1.model.PilotoEscuderia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PilotoEscuderiaRepository extends JpaRepository<PilotoEscuderia, Integer> {

    List<PilotoEscuderia> findByEscuderiaId(Integer escuderiaId);
    List<PilotoEscuderia> findByPilotoId(Integer pilotoId);
}
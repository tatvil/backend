package es.tatvil.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import es.tatvil.backend.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    // Esto genera automáticamente el SQL: SELECT * FROM weather WHERE ciudad = ? AND fecha BETWEEN ? AND ?
    List<Weather> findByCiudadAndFechaBetween(String ciudad, String desde, String hasta);
}

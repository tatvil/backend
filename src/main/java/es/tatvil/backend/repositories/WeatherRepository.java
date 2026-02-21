package es.tatvil.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import es.tatvil.backend.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    // Spring entenderá que debe filtrar por 'ciudad' y por el campo 'fecha'
    List<Weather> findByCiudadAndFechaBetween(String ciudad, LocalDate desde, LocalDate hasta);
}

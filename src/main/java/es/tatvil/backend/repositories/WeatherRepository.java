package es.tatvil.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.tatvil.backend.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    // Aquí puedes añadir métodos personalizados si quieres, 
    // por ejemplo: List<Weather> findByCiudad(String ciudad);
}

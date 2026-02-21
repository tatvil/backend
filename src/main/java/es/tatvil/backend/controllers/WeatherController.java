package es.tatvil.backend.controllers;

import es.tatvil.backend.entities.Weather;
import es.tatvil.backend.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*") // Para que tu web pueda consultar los datos sin errores de CORS
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }
    
    @GetMapping("/filter")
    public List<Weather> getWeatherFiltered(
        @RequestParam String ciudad,
        @RequestParam LocalDate desde,
        @RequestParam LocalDate hasta
    ) {
        return weatherRepository.findByCiudadAndFechaBetween(ciudad, desde, hasta);
    }
}
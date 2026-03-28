package es.tatvil.formula1.controller;

import es.tatvil.formula1.model.Escuderia;
import es.tatvil.formula1.model.Piloto;
import es.tatvil.formula1.model.PilotoEscuderia;
import es.tatvil.formula1.repository.PilotoEscuderiaRepository;
import es.tatvil.formula1.service.PilotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    private final PilotoService pilotoService;
    private final PilotoEscuderiaRepository pilotoEscuderiaRepository;

    public PilotoController(PilotoService pilotoService,
                            PilotoEscuderiaRepository pilotoEscuderiaRepository) {
        this.pilotoService = pilotoService;
        this.pilotoEscuderiaRepository = pilotoEscuderiaRepository;
    }

    @GetMapping
    public List<Piloto> listar() {
        return pilotoService.obtenerTodos();
    }

    @GetMapping("/{id}/escuderias")
    public List<Escuderia> getEscuderiasPorPiloto(@PathVariable Integer id) {
        return pilotoEscuderiaRepository.findByPilotoId(id)
                .stream()
                .map(PilotoEscuderia::getEscuderia)  // getter público
                .toList();
    }
}
package es.tatvil.formula1.controller;

import es.tatvil.formula1.model.Escuderia;
import es.tatvil.formula1.model.Piloto;
import es.tatvil.formula1.model.PilotoEscuderia;
import es.tatvil.formula1.repository.PilotoEscuderiaRepository;
import es.tatvil.formula1.service.EscuderiaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escuderias")
public class EscuderiaController {

    private final EscuderiaService escuderiaService;
    private final PilotoEscuderiaRepository pilotoEscuderiaRepository;

    public EscuderiaController(EscuderiaService escuderiaService,
                               PilotoEscuderiaRepository pilotoEscuderiaRepository) {
        this.escuderiaService = escuderiaService;
        this.pilotoEscuderiaRepository = pilotoEscuderiaRepository;
    }

    @GetMapping
    public List<Escuderia> listar() {
        return escuderiaService.obtenerTodos();
    }

    @GetMapping("/{id}/pilotos")
    public List<Piloto> getPilotosPorEscuderia(@PathVariable Integer id) {
        return pilotoEscuderiaRepository.findByEscuderiaId(id)
                .stream()
                .map(PilotoEscuderia::getPiloto)
                .toList();
    }
}

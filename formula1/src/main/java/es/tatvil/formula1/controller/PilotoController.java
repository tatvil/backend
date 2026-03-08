package es.tatvil.formula1.controller;

import es.tatvil.formula1.model.Piloto;
import es.tatvil.formula1.service.PilotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    private final PilotoService pilotoService;

    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @GetMapping
    public List<Piloto> listar() {
        return pilotoService.obtenerTodos();
    }
}
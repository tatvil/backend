package es.tatvil.formula1.controller;

import es.tatvil.formula1.model.Escuderia;
import es.tatvil.formula1.service.EscuderiaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escuderias")
public class EscuderiaController {

    private final EscuderiaService escuderiaService;

    public EscuderiaController(EscuderiaService escuderiaService) {
        this.escuderiaService = escuderiaService;
    }

    @GetMapping
    public List<Escuderia> listar() {
        return escuderiaService.obtenerTodos();
    }
}

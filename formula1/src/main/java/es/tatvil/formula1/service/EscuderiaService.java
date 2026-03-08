package es.tatvil.formula1.service;

import es.tatvil.formula1.model.Escuderia;
import es.tatvil.formula1.repository.EscuderiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuderiaService {

    private final EscuderiaRepository escuderiaRepository;

    public EscuderiaService(EscuderiaRepository escuderiaRepository) {
        this.escuderiaRepository = escuderiaRepository;
    }

    public List<Escuderia> obtenerTodos() {
        return escuderiaRepository.findAll();
    }
}
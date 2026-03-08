package es.tatvil.formula1.service;

import es.tatvil.formula1.model.Piloto;
import es.tatvil.formula1.repository.PilotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    private final PilotoRepository pilotoRepository;

    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    public List<Piloto> obtenerTodos() {
        return pilotoRepository.findAll();
    }
}
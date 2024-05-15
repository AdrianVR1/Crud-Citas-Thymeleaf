package com.citas.models.serviceImpl;

import com.citas.models.entity.Cita;
import com.citas.models.repository.CitaRepository;
import com.citas.models.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> listarCit() {
        return citaRepository.findAll();
    }

    @Override
    public void guardarCit(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public Optional<Cita> buscarId(int id) {
        return citaRepository.findById(id);
    }

    @Override
    public void borrar(int id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<Cita> buscarCit(String buscarCita) {
        if (buscarCita != null) {
            return citaRepository.listaCit(buscarCita);
        }
        return citaRepository.findAll();
    }
}

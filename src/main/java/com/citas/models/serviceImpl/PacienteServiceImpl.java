package com.citas.models.serviceImpl;

import com.citas.models.entity.Paciente;
import com.citas.models.repository.PacienteRepository;
import com.citas.models.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository repository;

    @Override
    public List<Paciente> listarpac(String palabraClave) {
        if(palabraClave != null) {
            return repository.listaPaci(palabraClave);
        }
        return repository.findAll();
    }

    @Override
    public void guardar(Paciente paciente) {
        repository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarId(int id) {
        return repository.findById(id);
    }

    @Override
    public void borrar(int id) {
        repository.deleteById(id);

    }

    @Override
    public List<Paciente> listar() {
        return repository.findAll();
    }
}

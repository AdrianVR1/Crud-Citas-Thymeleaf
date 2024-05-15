package com.citas.models.service;

import com.citas.models.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    public List<Paciente>listarpac(String palabraClave);
    public void guardar(Paciente paciente);
    public Optional<Paciente>buscarId(int id);
    public void borrar(int id);
    public List<Paciente>listar();
}

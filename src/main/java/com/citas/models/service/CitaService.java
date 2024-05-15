package com.citas.models.service;

import com.citas.models.entity.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    public List<Cita> listarCit();
    public void guardarCit(Cita cita);
    public Optional<Cita>buscarId(int id);
    public void borrar(int id);
    public List<Cita>buscarCit(String buscarCita);
}

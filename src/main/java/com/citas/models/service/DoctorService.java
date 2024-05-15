package com.citas.models.service;

import com.citas.models.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public List<Doctor>listarDoc();
    public void guardarDoc(Doctor doctor);
    public Optional<Doctor>buscarId(int id);
    public void borrar(int id);
    public List<Doctor>buscarDoc(String buscarDoc);
}

package com.citas.models.serviceImpl;

import com.citas.models.entity.Especialidad;
import com.citas.models.repository.EspecialidadRepository;
import com.citas.models.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository repository;

    @Override
    public List<Especialidad> listarEsp() {
        return repository.findAll();
    }
}

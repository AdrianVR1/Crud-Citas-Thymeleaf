package com.citas.models.serviceImpl;

import com.citas.models.entity.Doctor;
import com.citas.models.repository.DoctorRepository;
import com.citas.models.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> listarDoc() {
        return doctorRepository.findAll();
    }

    @Override
    public void guardarDoc(Doctor doctor) {
        doctorRepository.save(doctor);

    }

    @Override
    public Optional<Doctor> buscarId(int id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void borrar(int id) {
        doctorRepository.deleteById(id);

    }

    @Override
    public List<Doctor> buscarDoc(String buscarDoc) {
        if(buscarDoc != null) {
            return doctorRepository.buscarDoc(buscarDoc);
        }
        return doctorRepository.findAll();
    }
}

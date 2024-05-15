package com.citas.models.repository;

import com.citas.models.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query(value = "SELECT * FROM pacientes p WHERE p.nombre LIKE %?1%", nativeQuery = true)
    public List<Paciente>listaPaci(String palabraClave);
}

package com.citas.models.repository;

import com.citas.models.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    @Query(value = "SELECT * FROM citas c WHERE c.fecha LIKE %?1%", nativeQuery = true)
    public List<Cita> listaCit(String buscarCita);
}

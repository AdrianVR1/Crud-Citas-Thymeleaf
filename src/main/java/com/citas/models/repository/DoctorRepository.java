package com.citas.models.repository;

import com.citas.models.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query(value = "SELECT * FROM doctores dc WHERE dc.nombre LIKE %?1%", nativeQuery = true)

    public List<Doctor>buscarDoc(String buscarDoc);


}

package com.citas.models.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas")
@Entity

public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcitas")
    private int idcitas;

    @NotNull(message = "La fecha no puede estar en blanco")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha")
    private Date fecha;

    @NotBlank(message = "El motivo no puede estar en blanco")
    @Size(min = 20, max = 300, message = "El motivo debe tener entre 5 y 300 caracteres")
    @Column(name = "motivo")
    private String motivo;

    @NotBlank(message = "Las observaciones no pueden estar en blanco")
    @Size(min = 10, max = 100, message = "Las observaciones deben tener entre 5 y 100 caracteres")
    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpacientes")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddoctores")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;
}

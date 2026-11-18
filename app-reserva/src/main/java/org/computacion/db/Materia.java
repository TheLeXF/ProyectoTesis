package org.computacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String carrera;

    private String periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor", nullable = false)
    private Profesor profesor;
}

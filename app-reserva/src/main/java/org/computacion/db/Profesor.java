package org.computacion.db;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String email;
}

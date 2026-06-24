package com.diego.thymeleaf.thymeleaf.web.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARGOS")
@Getter
@Setter
public class Cargo extends AbstractEntity<Long> {
    @Column(name = "NAME", nullable = false, length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;
}

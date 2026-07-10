package com.diego.thymeleaf.thymeleaf.web.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEPARTAMENTOS")
@Getter
@Setter
public class Departamento extends AbstractEntity<Long>{

    @Column(name = "NAME", nullable = false, length = 60)
    private String name;

    @OneToMany(mappedBy = "departamento")
    List<Cargo> cargos;
}

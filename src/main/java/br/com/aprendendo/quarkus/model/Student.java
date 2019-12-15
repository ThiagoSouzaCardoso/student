package br.com.aprendendo.quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends PanacheEntity {

    @NotNull
    public String name;

}

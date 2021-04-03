package com.example.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@KeySpace("country")
public class Country implements Serializable {
    private static final long serialVersionUID = -5447277298479371496L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String codeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Country() {
//    }

    public Country(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String toString() {
        return id + ". " + name + " (" + codeName + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(name, country.name) &&
                Objects.equals(codeName, country.codeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, codeName);
    }
}

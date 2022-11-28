package com.example.weatherapispring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
@Entity
@JsonIgnoreProperties("currentCondition")
public class City {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "english_name", nullable = false, updatable = false)
    private String englishName;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "city")
    private CurrentCondition currentCondition;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", englishName='" + englishName + '\'' +
                '}';
    }
}
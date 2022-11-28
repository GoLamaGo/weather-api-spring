package com.example.weatherapispring.model.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "current_condition")
@Entity
public class CurrentCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;
    @Column(name = "unit", length = 3)
    private String unit;

    @OneToOne
    @JoinColumn(
            name = "city_id",
            foreignKey = @ForeignKey(
                    name = "current_condition_city_fk"
            )
    )
    private City city;

}

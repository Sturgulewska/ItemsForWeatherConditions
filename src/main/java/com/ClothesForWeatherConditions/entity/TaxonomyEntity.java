package com.ClothesForWeatherConditions.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "taxonomy")
public class TaxonomyEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;
}

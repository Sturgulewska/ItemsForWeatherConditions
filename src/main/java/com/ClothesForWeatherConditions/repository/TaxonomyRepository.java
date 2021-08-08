package com.ClothesForWeatherConditions.repository;

import com.ClothesForWeatherConditions.entity.TaxonomyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepository extends CrudRepository<TaxonomyEntity, Long> {
}

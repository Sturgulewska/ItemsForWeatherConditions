package com.ClothesForWeatherConditions.service;

import com.ClothesForWeatherConditions.entity.TaxonomyEntity;
import com.ClothesForWeatherConditions.repository.TaxonomyRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaxonomyService {


    private final TaxonomyRepository taxonomyRepository;

    public TaxonomyService(TaxonomyRepository taxonomyRepository){
        this.taxonomyRepository = taxonomyRepository;
    }

    public TaxonomyEntity newTaxonomy(String name, String path) {
        TaxonomyEntity entity = new TaxonomyEntity();
        entity.setName(name);
        entity.setPath(path);
        return saveTaxonomy(entity);
    }

    public Optional<TaxonomyEntity> findById(Long id){
        return taxonomyRepository.findById(id);
    }

    public TaxonomyEntity saveTaxonomy(TaxonomyEntity entity){
        return taxonomyRepository.save(entity);
    }
}

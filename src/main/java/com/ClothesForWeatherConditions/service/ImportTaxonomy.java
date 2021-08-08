package com.ClothesForWeatherConditions.service;

import com.ClothesForWeatherConditions.domain.DtoTaxonomy;
import com.ClothesForWeatherConditions.domain.DtoTaxonomyBasic;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImportTaxonomy {
    private final EtsyService etsyService;
    private final TaxonomyService taxonomyService;

    public ImportTaxonomy(EtsyService etsyService,
                          TaxonomyService taxonomyService) {
        this.etsyService = etsyService;
        this.taxonomyService = taxonomyService;
    }

    public void importTaxonomyFromEtsy() throws JsonProcessingException {
        DtoTaxonomyBasic dtoTaxonomyBasic = etsyService.getTaxonomyList();
        ArrayList<DtoTaxonomy> taxonomyList = dtoTaxonomyBasic.getTaxonomyList();
        taxonomyList.forEach(this::saveTaxonomy);
    }

    public void saveTaxonomy(DtoTaxonomy t) {
        taxonomyService.newTaxonomy(t.getName(), t.getPath());
        ArrayList<DtoTaxonomy> childrenTaxonomy = t.getChildren();
        if (childrenTaxonomy != null && !childrenTaxonomy.isEmpty()) {
            childrenTaxonomy.forEach(this::saveTaxonomy);
        }
    }
}

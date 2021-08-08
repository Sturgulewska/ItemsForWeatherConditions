package com.ClothesForWeatherConditions.controller;

import com.ClothesForWeatherConditions.entity.TaxonomyEntity;
import com.ClothesForWeatherConditions.service.ImportTaxonomy;
import com.ClothesForWeatherConditions.service.TaxonomyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/taxonomy")
public class TaxonomyController {
    private final TaxonomyService taxonomyService;

    private final ImportTaxonomy importTaxonomy;

    public TaxonomyController(TaxonomyService taxonomyService, ImportTaxonomy importTaxonomy
    ) {
        this.taxonomyService = taxonomyService;
        this.importTaxonomy = importTaxonomy;
    }

    @RequestMapping(value = "getTaxonomy/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTaxonomy (@PathVariable("id") Long id){
        Optional<TaxonomyEntity> optionalTaxonomyEntity = taxonomyService.findById(id);
        return new ResponseEntity<>(optionalTaxonomyEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "import_taxonomy", method = RequestMethod.GET)
    public ResponseEntity<Object> importTaxonomy () throws JsonProcessingException {
        importTaxonomy.importTaxonomyFromEtsy();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

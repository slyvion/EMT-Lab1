package com.finki.BookStore.controllers;

import com.finki.BookStore.models.entities.Country;
import com.finki.BookStore.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/createOrUpdate")
    public Country createOrUpdate(@RequestBody Country country) {
        return countryService.save(country);
    }

    @GetMapping("")
    public List<Country> getAllCountries(){ return countryService.getAll();}
}

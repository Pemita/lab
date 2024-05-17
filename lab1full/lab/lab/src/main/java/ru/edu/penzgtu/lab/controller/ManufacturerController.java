package ru.edu.penzgtu.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.entity.Manufacturer;
import ru.edu.penzgtu.lab.service.ManufacturerService;
import java.util.List;

@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> findAll() {
        return manufacturerService.findAllmanufacturers();
    }

    @GetMapping(" /manufacturer/{id}")
    public Manufacturer getById(@PathVariable Long id) {
        return manufacturerService.findManufacturerById(id);
    }

    @PostMapping

    @ResponseStatus(HttpStatus.CREATED)
    public void createManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
    }

    @PutMapping("/manufacturer/")
    public void updateManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.updateManufacturer(manufacturer);
    }

    @DeleteMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturerById(id);
    }
}
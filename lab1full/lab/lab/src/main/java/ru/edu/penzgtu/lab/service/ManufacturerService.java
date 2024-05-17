package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.entity.Manufacturer;
import ru.edu.penzgtu.lab.repo.ManufacturerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAllmanufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer findManufacturerById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer newManufacturer) {
        Manufacturer oldManufacturer = manufacturerRepository.findById(newManufacturer.getId())
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        oldManufacturer.setName(newManufacturer.getName());
        manufacturerRepository.save(oldManufacturer);
    }

    public void deleteManufacturerById(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
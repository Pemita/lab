package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.ManufacturerDto;
import ru.edu.penzgtu.lab.entity.Manufacturer;
import ru.edu.penzgtu.lab.repo.ManufacturerRepository;
import ru.edu.penzgtu.lab.service.mapper.ManufacturerMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private  final ManufacturerMapper manufacturerMapper;
    public List<ManufacturerDto> findAllManufacturers() {
        return manufacturerMapper.toListDto( manufacturerRepository.findAll());
    }

    public ManufacturerDto findManufacturerById(Long id) {
        Manufacturer manufacturer= manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manufacturer not found"));

        return manufacturerMapper.toDto(manufacturer);
    }

    public void saveManufacturer(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer= manufacturerMapper.toEntity(manufacturerDto);
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(ManufacturerDto newManufacturer) {
        Manufacturer oldManufacturer = manufacturerRepository.findById(newManufacturer.getId())
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));

        oldManufacturer.setName(newManufacturer.getName());

        manufacturerRepository.save(oldManufacturer);
    }

    public void deleteManufacturerById(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
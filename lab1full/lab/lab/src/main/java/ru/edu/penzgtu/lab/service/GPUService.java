package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.repo.GPURepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GPUService {
    private final GPURepository manufacturerRepository;

    public List<GPU> findAllGPUs() {
        return manufacturerRepository.findAll();
    }

    public GPU findGPUById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("GPU not found"));

    }

    public void saveGPU(GPU manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateGPU(GPU newGPU) {
        GPU oldGPU = manufacturerRepository.findById(newGPU.getId())
                .orElseThrow(() -> new RuntimeException("GPU not found"));

        oldGPU.setModel(newGPU.getModel());

        manufacturerRepository.save(oldGPU);
    }

    public void deleteGPUById(Long id) {manufacturerRepository.deleteById(id);}
}
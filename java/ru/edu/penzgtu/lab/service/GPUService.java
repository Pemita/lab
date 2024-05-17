package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.GPUDto;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.repo.GPURepository;
import ru.edu.penzgtu.lab.service.mapper.GPUMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GPUService {
    private final GPURepository gpuRepository;
    private  final GPUMapper gpuMapper;
    public List<GPUDto> findAllGPUs() {
        return gpuMapper.toListDto( gpuRepository.findAll());
    }

    public GPUDto findGPUById(Long id) {
        GPU gpu= gpuRepository.findById(id).orElseThrow(() -> new RuntimeException("GPU not found"));

        return gpuMapper.toDto(gpu);
    }

    public void saveGPU(GPUDto gpuDto) {
        GPU gpu= gpuMapper.toEntity(gpuDto);
        gpuRepository.save(gpu);
    }

    public void updateGPU(GPUDto newGPU) {
        GPU oldGPU = gpuRepository.findById(newGPU.getId())
                .orElseThrow(() -> new RuntimeException("GPU not found"));

        oldGPU.setModel(newGPU.getModel());
        oldGPU.setCharacteristics(newGPU.getCharacteristics());

        gpuRepository.save(oldGPU);
    }

    public void deleteGPUById(Long id) {
        gpuRepository.deleteById(id);
    }
}
package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.GPUDto;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.entity.Manufacturer;

import java.util.List;

@Service
public class GPUMapper {

    public List<GPUDto> toListDto(List<GPU> gpus) {
        return gpus.stream().map(this::toDto).toList();
    }

    public GPUDto toDto(GPU gpu){
        return GPUDto.builder()
                .id(gpu.getId())
                .model(gpu.getModel())
                .characteristics(gpu.getCharacteristics())
                .manufacturers(gpu.getManufacturers().stream().
                        map(Manufacturer::getName)
                        .toList())
                .build();
    }

    public GPU toEntity(GPUDto gpuDto){
        GPU gpu = new GPU();

        gpu.setId(gpu.getId());
        gpu.setModel((gpuDto.getModel()));

        return gpu;
    }
}
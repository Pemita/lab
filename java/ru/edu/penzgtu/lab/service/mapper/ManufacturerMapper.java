package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.ManufacturerDto;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.entity.Manufacturer;

import java.util.List;

@Service
public class ManufacturerMapper {

    public List<ManufacturerDto> toListDto(List<Manufacturer> manufacturers) {
        return manufacturers.stream().map(this::toDto).toList();
    }

    public ManufacturerDto toDto(Manufacturer manufacturer){
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .gpus(manufacturer.getGpus().stream().
                        map(GPU::getModel)
                        .toList())
                .build();
    }

    public Manufacturer toEntity(ManufacturerDto manufacturerDto){
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setId(manufacturer.getId());
        manufacturer.setName((manufacturerDto.getName()));

        return manufacturer;
    }
}

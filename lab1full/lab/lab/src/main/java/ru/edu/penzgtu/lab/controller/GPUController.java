package ru.edu.penzgtu.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.service.GPUService;
import java.util.List;

@RestController
@RequestMapping("/gpus")
@RequiredArgsConstructor
public class GPUController {
    private final GPUService gpuService;

    @GetMapping
    public List<GPU> findAll() {
        return gpuService.findAllGPUs();
    }

    @GetMapping(" /gpu/{id}")
    public GPU getById(@PathVariable Long id) {
        return gpuService.findGPUById(id);
    }

    @PostMapping

    @ResponseStatus(HttpStatus.CREATED)
    public void createGPU(@RequestBody GPU gpu) {
        gpuService.saveGPU(gpu);
    }

    @PutMapping("/gpu/")
    public void updateGPU(@RequestBody GPU gpu) {
        gpuService.updateGPU(gpu);
    }

    @DeleteMapping("/gpu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGPU(@PathVariable GPU manufacturer) {
        gpuService.deleteGPU(manufacturer);
    }
}
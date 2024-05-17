package ru.edu.penzgtu.lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.baseresponse.BaseResponseService;
import ru.edu.penzgtu.lab.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.lab.dto.GPUDto;
import ru.edu.penzgtu.lab.entity.GPU;
import ru.edu.penzgtu.lab.service.GPUService;
import java.util.List;

@Validated
@RestController
@RequestMapping("/gpus")
@RequiredArgsConstructor
public class GPUController {
    private final GPUService gpuService;
    private final BaseResponseService baseResponseService;
    @Operation(
            summary = "Получение всех видеокарт",description = "Позволяет выгрузить всех авторов из БД"
    )
    @GetMapping
    public ResponseWrapper<List<GPUDto>> findAll() {

        return baseResponseService.wrapSuccessResponse(gpuService.findAllGPUs());
    }

    @Operation(
            summary = "Получение видеокарты по ID",description = "Позволяет выгрузить одну видеокарту по ID из БД"
    )
    @GetMapping("/gpu/{id}")
    public ResponseWrapper<GPUDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(gpuService.findGPUById(id));
    }

    @Operation(
            summary = "Создать видеокарту",description = "Позволяет создать новую запись о видеокарты в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGPU(@RequestBody @Valid GPUDto gpu) {
        gpuService.saveGPU(gpu);
    }

    @Operation(
            summary = "Обновить данные о видеокарте",description = "Позволяет обновить информацию о видеокарте в БД"
    )
    @PutMapping("/gpu/")
    public void updateGPU(@RequestBody @Valid GPUDto gpu) {
        gpuService.updateGPU(gpu);
    }

    @Operation(
            summary = "Удалить видеокарту по ID",description = "Позволяет удалить видеокарту по ID"
    )
    @DeleteMapping("/gpu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGPU(@PathVariable @Min(0) Long id) {
        gpuService.deleteGPUById(id);
    }
}
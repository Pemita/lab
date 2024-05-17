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
import ru.edu.penzgtu.lab.dto.ManufacturerDto;
import ru.edu.penzgtu.lab.service.ManufacturerService;
import java.util.List;

@Validated
@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;
    private final BaseResponseService baseResponseService;
    @Operation(
            summary = "Получение всех производителей", description = "Позволяет выгрузить всех авторов из БД"
    )
    @GetMapping
    public ResponseWrapper<List<ManufacturerDto>> findAll() {

        return baseResponseService.wrapSuccessResponse(manufacturerService.findAllManufacturers());
    }

    @Operation(
            summary = "Получение производителя по ID", description = "Позволяет выгрузить одного автора по ID из БД"
    )
    @GetMapping("/manufacturer/{id}")
    public ResponseWrapper<ManufacturerDto> getById(@PathVariable @Min(0) Long id) {

        return baseResponseService.wrapSuccessResponse(manufacturerService.findManufacturerById(id));
    }

    @Operation(
            summary = "Создать производителя",description = "Позводяет создать новую запись об производителе в БД"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createManufacturer(@RequestBody @Valid ManufacturerDto manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
    }

    @Operation(
            summary = "Обновить данные о производителе",description = "Позволяет обновить информацию о производителе в БД"
    )
    @PutMapping("/manufacturer/")
    public void updateManufacturer(@RequestBody @Valid ManufacturerDto manufacturer) {
        manufacturerService.updateManufacturer(manufacturer);
    }

    @Operation(
            summary = "Удалить производителя по ID",description = "Позводяет удалить производителя по ID из БД"
    )
    @DeleteMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManufacturer(@PathVariable @Min(0) Long id) {
        manufacturerService.deleteManufacturerById(id);
    }
}
package ru.edu.penzgtu.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о производителе")
public class ManufacturerDto {

    @JsonProperty("id")
    @Schema(description = "ID производителя в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название производителя", example = "AMD")
    private String name;

    @JsonProperty("gpus")
    @Schema(description = "Названия моделей видеокарт производителей")
    private List<String> gpus;
}

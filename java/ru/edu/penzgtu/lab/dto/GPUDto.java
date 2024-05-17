package ru.edu.penzgtu.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о видеокарте")
public class GPUDto {
    @JsonProperty("id")
    @Schema(description = "ID видеокарты в БД", example="123")
    private Long id;

    @JsonProperty("model")
    @NotBlank
    @Schema(description = "Модель видеокарты", example="GTX 1660")
    private String model;

    @JsonProperty("characteristics")
    @NotBlank
    @Schema(description = "Характеристики видеокарты", example="6 gb GDDR5 1530 MHz")
    private String characteristics;

    @JsonProperty("manufacturers")
    @Schema(description = "Названия производителей видоекарт")
    private List<String> manufacturers;
}

package com.app.auth.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveProduct implements Serializable {

    @NotBlank
    private String name;

    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @Min(value = 1)
    private Long categoryId;
}

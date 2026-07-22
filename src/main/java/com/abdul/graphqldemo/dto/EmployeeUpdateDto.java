package com.abdul.graphqldemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
public record EmployeeUpdateDto(
		@NotBlank(message = "Employee name is required")
        String name,
        @Positive(message = "Salary must be greater than zero")
        Double salary
) {
}



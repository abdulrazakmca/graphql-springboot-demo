package com.abdul.graphqldemo.dto;

import java.util.List;

public record EmployeePageDto(

        List<EmployeeDto> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int pageSize,
        boolean first,
        boolean last
) {
}
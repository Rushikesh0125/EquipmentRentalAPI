package com.example.EquipmentRental.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRequest {

    /*
     * Equipment Get Request should contain following attributes
     * Each attribute is following certain rules
     * Category can't be null as it is being used as filter for finding Equipment
     * while start and end date need to follow the format "yyyy-MM-dd HH:mm:ss.SSS"
     */
    @NotBlank(message = "Category is required")
    private String category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime endDate;
}

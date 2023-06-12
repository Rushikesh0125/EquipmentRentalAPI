package com.example.EquipmentRental.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRequest {
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

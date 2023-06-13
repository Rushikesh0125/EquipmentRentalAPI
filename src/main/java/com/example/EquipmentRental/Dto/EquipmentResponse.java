package com.example.EquipmentRental.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentResponse {
    private Long equipmentId;
    private double pricePerHour;
    private String name;
    private String category;
    private String image;
}

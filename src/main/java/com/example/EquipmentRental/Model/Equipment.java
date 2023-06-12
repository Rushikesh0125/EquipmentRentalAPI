package com.example.EquipmentRental.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

@Entity
@Table(name = "equipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    private String name;
    private String category;
    @Lob
    private String image;

    private double pricePerDay;
}

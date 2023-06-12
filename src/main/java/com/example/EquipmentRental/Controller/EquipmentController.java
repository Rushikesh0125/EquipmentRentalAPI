package com.example.EquipmentRental.Controller;

import com.example.EquipmentRental.Dto.EquipmentRequest;
import com.example.EquipmentRental.Dto.EquipmentResponse;
import com.example.EquipmentRental.Model.Equipment;
import com.example.EquipmentRental.Service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService service){
        this.equipmentService = service;
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentResponse> getListOfAvailableEquipment(@RequestBody EquipmentRequest equipmentRequest){
        List<Equipment> list= equipmentService.getAvailableEquipmentFromCategory(equipmentRequest);
        return list.stream().map(this::convertToDto).toList();
    }

    public EquipmentResponse convertToDto(Equipment eqp){
        EquipmentResponse obj = EquipmentResponse.builder().name(eqp.getName())
                .category(eqp.getCategory())
                .image(eqp.getImage())
                .pricePerDay(eqp.getPricePerDay())
                .build();

        return obj;
    }

}

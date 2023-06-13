package com.example.EquipmentRental.Controller;

import com.example.EquipmentRental.Dto.EquipmentRequest;
import com.example.EquipmentRental.Dto.EquipmentResponse;
import com.example.EquipmentRental.Model.Equipment;
import com.example.EquipmentRental.Service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private final EquipmentService equipmentService;

    //Constructor initialization of Equipment service object
    public EquipmentController(EquipmentService service){
        this.equipmentService = service;
    }

    /*
    @Param takes DTO as param - Equipment Request DTO (Dto/EquipmentRequest)
    @returns A list of Equipment Response DTO (Dto/EquipmentResponse)
    *This function passes on the equipment request object from the request to the equipment service.
    *From service layer we get list of equipments we convert it to list of response objects
     */
    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentResponse> getListOfAvailableEquipment(@Valid @RequestBody EquipmentRequest equipmentRequest){
        List<Equipment> list= equipmentService.getAvailableEquipmentFromCategory(equipmentRequest);
        //converting to list of dto
        return list.stream().map(this::convertToDto).toList();
    }

    /*
    @Param Equipment object
    @Returns DTO object
    *This utility function converts a Equipment object into a Equipment response DTO
     */
    public EquipmentResponse convertToDto(Equipment eqp){
        EquipmentResponse obj = EquipmentResponse.builder().name(eqp.getName())
                .category(eqp.getCategory())
                .image(eqp.getImage())
                .pricePerHour(eqp.getPricePerHour())
                .build();

        return obj;
    }

}

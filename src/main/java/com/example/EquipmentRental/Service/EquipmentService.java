package com.example.EquipmentRental.Service;

import com.example.EquipmentRental.Dto.EquipmentRequest;
import com.example.EquipmentRental.Model.Equipment;
import com.example.EquipmentRental.Repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAvailableEquipmentFromCategory(EquipmentRequest equipmentRequest) {
        return equipmentRepository.findAllAvailableByCategory(equipmentRequest.getCategory(),
                equipmentRequest.getStartDate(),
                equipmentRequest.getEndDate());
    }
}

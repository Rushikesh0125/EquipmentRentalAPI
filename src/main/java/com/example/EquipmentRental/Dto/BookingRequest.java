package com.example.EquipmentRental.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


/*
*Data transfer object for requesting a booking
* The request should have defined parameters
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    /*
    * Booking Put Request should contain following attributes
    * Each attribute is following certain rules
    * equipment Id can't be null
    * while start and end date need to follow the format "yyyy-MM-dd HH:mm:ss.SSS"
     */
    @NotNull
    private Long equipmentId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime endDate;

}

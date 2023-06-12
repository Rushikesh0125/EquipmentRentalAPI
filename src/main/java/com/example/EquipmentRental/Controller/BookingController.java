package com.example.EquipmentRental.Controller;

import com.example.EquipmentRental.Dto.BookingRequest;
import com.example.EquipmentRental.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    public BookingController(BookingService service){
        this.bookingService = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody BookingRequest bookingRequest){
        bookingService.addBooking(bookingRequest);
    }

}

package com.example.EquipmentRental.Controller;

import com.example.EquipmentRental.Dto.BookingRequest;
import com.example.EquipmentRental.Service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    //Constructor initializing of the booking service object
    public BookingController(BookingService service){
        this.bookingService = service;
    }

    /*
    @Param takes DTO as param - BookingRequest DTO (Dto/BookingRequest)
    *Invokes addBooking function in Booking service
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody BookingRequest bookingRequest) throws Exception {
        bookingService.addBooking(bookingRequest);
    }

}

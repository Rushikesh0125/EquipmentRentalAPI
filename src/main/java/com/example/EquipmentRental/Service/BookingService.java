package com.example.EquipmentRental.Service;

import com.example.EquipmentRental.Dto.BookingRequest;
import com.example.EquipmentRental.Model.Booking;
import com.example.EquipmentRental.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    public void addBooking(@RequestBody BookingRequest bookingRequest){
        Booking booking = Booking.builder()
                .startDate(bookingRequest.getStartDate())
                .endDate(bookingRequest.getEndDate())
                .equipmentId(bookingRequest.getEquipmentId())
                .build();

        bookingRepository.save(booking);
    }
}

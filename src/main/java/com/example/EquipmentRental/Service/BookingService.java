package com.example.EquipmentRental.Service;

import com.example.EquipmentRental.Dto.BookingRequest;
import com.example.EquipmentRental.Model.Booking;
import com.example.EquipmentRental.Model.Equipment;
import com.example.EquipmentRental.Repository.BookingRepository;
import com.example.EquipmentRental.Repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final EquipmentRepository equipmentRepository;

    /*
    @Param Takes a Request body DTO as param
    @Returns total price for booking
     */
    public double getPricePerHour(@RequestBody BookingRequest bookingRequest) throws NoSuchElementException {
        //Getting the equipment from equipment repository
        Optional<Equipment> eqp = equipmentRepository.findById(bookingRequest.getEquipmentId());

        //Calculating the duration between start and end date
        Duration duration =  Duration.between(bookingRequest.getEndDate(), bookingRequest.getStartDate());

        //returns total price as total price = duration in hours * price per hour
        return Math.abs((eqp.orElseThrow().getPricePerHour())*duration.toHours());
    }

    /*
    @param takes Booking request DTO
    *constructs booking model and saves it into repository
     */
    public void addBooking(@RequestBody BookingRequest bookingRequest) throws Exception{
        double totalAmount = getPricePerHour(bookingRequest);
        if(bookingRequest.getStartDate().isAfter(bookingRequest.getEndDate())){
            throw new Exception("Invalid Start or End date");
        }

        Booking booking = Booking.builder()
                .startDate(bookingRequest.getStartDate())
                .endDate(bookingRequest.getEndDate())
                .equipmentId(bookingRequest.getEquipmentId())
                .totalAmount(totalAmount)
                .build();

        bookingRepository.save(booking);
    }
}

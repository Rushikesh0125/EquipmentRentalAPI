package com.example.EquipmentRental.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*Booking Entity with following annotations to make sure we get :-
* Getters and setters (Data from Lombok)
* AllArgs and NoArgs constructors (Lombok)
* Builder pattern form Lombok
* Entity to annotate model as an entity and map it to table
* This entity has the following attributes -
 *Booking Id | Equipment Id | Start date | End date | total amount
 */
@Entity
@Table(name="bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    //Associated equipment Id
    private Long equipmentId;

    //Start and end dates
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private double totalAmount; // total cost of booking
}

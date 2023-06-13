package com.example.EquipmentRental.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Equipment Entity with following annotations to make sure we get :-
 * Getters and setters (Data from Lombok)
 * AllArgs and NoArgs constructors (Lombok)
 * Builder pattern form Lombok
 * Entity to annotate model as an entity and map it to table
 * This entity has the following attributes -
 *Equipment Id | Name | Category | Image | Price per hour
 */
@Entity
@Table(name = "equipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    //Name of Equipment
    private String name;

    //Category to which equipment belongs to
    private String category;

    //Image of the Equipment
    @Lob
    private String image;

    //Renting price of Equipment on hourly basis
    private double pricePerHour;
}

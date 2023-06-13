package com.example.EquipmentRental.Repository;

import com.example.EquipmentRental.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    /*
    * The following query works in two parts
    * First part -
    *       - Select eq From Equipment eq Where eq.category = Param category
    *       - The above query selects equipment from equipment table
    *       - such that category passed in param is matching the category associated with equipment in the table
    * Second part -
    *       - Select 1 From Booking bk
    *       - Where bk.equipmentId = eq.equipmentId
    *       - This selects equipment Id from booking table
    *       - such that equipment Ids matches to previously selected equipment
    *       - AND (bk.startDate BETWEEN :Param start_date AND :Param end_date " +
            "           OR bk.endDate BETWEEN :Param start_date AND :Param end_dat " +
            "           OR :Param start_date BETWEEN bk.startDate AND bk.endDate " +
            "           OR :Param end_dat BETWEEN bk.startDate AND bk.endDate)
    *       - This AND clause checks if start and end date from param is colliding with other bookings present in booking table
    *       - We select all such entries which are not in second set of selection as those are colliding with other bookings
     */
    @Query("SELECT eq " +
            "FROM Equipment eq " +
            "WHERE eq.category = :category " +
            "AND NOT EXISTS (" +
            "    SELECT 1 " +
            "    FROM Booking bk " +
            "    WHERE bk.equipmentId = eq.equipmentId " +
            "      AND (bk.startDate BETWEEN :start_date AND :end_date " +
            "           OR bk.endDate BETWEEN :start_date AND :end_date " +
            "           OR :start_date BETWEEN bk.startDate AND bk.endDate " +
            "           OR :end_date BETWEEN bk.startDate AND bk.endDate)" +
            ")")
    List<Equipment> findAllAvailableByCategory(@Param("category") String category,
                                               @Param("start_date") LocalDateTime startDate,
                                               @Param("end_date") LocalDateTime endDate);
}

package com.example.EquipmentRental.Repository;

import com.example.EquipmentRental.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
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

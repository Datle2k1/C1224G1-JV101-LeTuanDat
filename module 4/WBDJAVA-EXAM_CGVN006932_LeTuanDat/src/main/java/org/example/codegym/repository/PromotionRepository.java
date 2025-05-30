package org.example.codegym.repository;

import org.example.codegym.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query("SELECT p FROM Promotion p WHERE (:discount IS NULL OR p.discount = :discount) " +
            "AND (:startDate IS NULL OR p.startDate = :startDate) " +
            "AND (:endDate IS NULL OR p.endDate = :endDate)")
    List<Promotion> findByDiscountAndStartDateAndEndDate(
            @Param("discount") Integer discount,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
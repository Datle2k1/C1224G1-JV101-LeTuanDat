package org.example.codegym.service;

import org.example.codegym.model.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    List<Promotion> getAllPromotions();
    Optional<Promotion> getPromotionById(Long id);
    void savePromotion(Promotion promotion);
    void deletePromotion(Long id);
    List<Promotion> searchByAllConditions(Integer discount, LocalDate startDate, LocalDate endDate);
}

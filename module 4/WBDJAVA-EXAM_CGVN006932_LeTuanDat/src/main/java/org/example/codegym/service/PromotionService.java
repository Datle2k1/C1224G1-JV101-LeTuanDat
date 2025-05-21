package org.example.codegym.service;

import org.example.codegym.model.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    public List<Promotion> getAllPromotions();
    public Optional<Promotion> getPromotionById(Long id);
    public void savePromotion(Promotion promotion);
    public void deletePromotion(Long id);
    public List<Promotion> searchByAllConditions(Integer discount, LocalDate startDate, LocalDate endDate);
}

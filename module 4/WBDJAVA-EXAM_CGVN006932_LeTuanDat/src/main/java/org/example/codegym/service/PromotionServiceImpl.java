package org.example.codegym.service;

import org.example.codegym.model.Promotion;
import org.example.codegym.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    public void savePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public List<Promotion> searchByAllConditions(Integer discount, LocalDate startDate, LocalDate endDate) {
        return promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
    }
}
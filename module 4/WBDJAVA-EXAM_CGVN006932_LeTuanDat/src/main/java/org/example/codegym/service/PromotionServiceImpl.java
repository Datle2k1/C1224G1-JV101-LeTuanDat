package org.example.codegym.service;

import org.example.codegym.model.Promotion;
import org.example.codegym.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService{

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    public void savePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> searchByAllConditions(Integer discount, LocalDate startDate, LocalDate endDate) {
        return promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
    }
}
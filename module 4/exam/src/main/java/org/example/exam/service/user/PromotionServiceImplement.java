package org.example.exam.service.user;

import org.example.exam.model.Promotion;
import org.example.exam.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PromotionServiceImplement implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImplement(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }
}
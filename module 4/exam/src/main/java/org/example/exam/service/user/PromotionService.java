package org.example.exam.service.user;

import org.example.exam.model.Promotion;

import java.util.List;

public interface PromotionService {
    List<Promotion> findAll();
    void save(Promotion promotion);
}

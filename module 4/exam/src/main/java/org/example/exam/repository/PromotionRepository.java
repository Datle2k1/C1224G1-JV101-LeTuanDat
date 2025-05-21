package org.example.exam.repository;

import org.example.exam.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.favoriteMedia WHERE u.id = :userId")
//    User findByIdWithFavoriteMedia(@Param("userId") Long userId);
}

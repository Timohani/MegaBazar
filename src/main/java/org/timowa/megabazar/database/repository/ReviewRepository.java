package org.timowa.megabazar.database.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.timowa.megabazar.database.entity.Product;
import org.timowa.megabazar.database.entity.Review;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserIdAndProduct(Long userId, Product product);

    Page<Review> findAllByProductId(Pageable pageable, Long productId);
}
package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

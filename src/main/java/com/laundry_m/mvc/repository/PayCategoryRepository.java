package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.PayCategory;

public interface PayCategoryRepository extends JpaRepository<PayCategory, Long> {

}

package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Fee;

public interface FeeRepository extends JpaRepository<Fee, Long>{

}

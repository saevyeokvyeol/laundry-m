package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Laundry;

public interface LaundryRepository extends JpaRepository<Laundry, Long>{

}

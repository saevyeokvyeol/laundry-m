package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Metapay;

public interface MetapayRepository extends JpaRepository<Metapay, Long> {

}

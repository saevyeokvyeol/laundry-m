package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}

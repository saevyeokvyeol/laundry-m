package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.PayLog;

public interface PayLogRepository extends JpaRepository<PayLog, Long> {

}

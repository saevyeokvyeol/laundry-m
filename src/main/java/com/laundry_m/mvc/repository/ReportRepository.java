package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}

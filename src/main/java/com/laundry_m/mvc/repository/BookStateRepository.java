package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.BookState;

public interface BookStateRepository extends JpaRepository<BookState, Integer>{

}

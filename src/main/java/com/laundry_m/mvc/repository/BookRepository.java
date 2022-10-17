package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

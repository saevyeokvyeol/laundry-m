package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Clothes;

public interface ClothesRepository extends JpaRepository<Clothes, Integer>{

}

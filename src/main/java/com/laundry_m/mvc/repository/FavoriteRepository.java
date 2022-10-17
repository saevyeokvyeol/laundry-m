package com.laundry_m.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry_m.mvc.domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

}

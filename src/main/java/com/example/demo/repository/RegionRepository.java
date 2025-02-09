package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
  boolean existsByName(String name);
}

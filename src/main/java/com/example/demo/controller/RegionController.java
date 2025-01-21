package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("api/regions")
@RequiredArgsConstructor
public class RegionController {

  private final RegionRepository regionRepository;

  @GetMapping
  public List<Region> getAllRegions() {
    return regionRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<?> createRegion(@RequestBody Region region) {
    if (regionRepository.existsByName(region.getName())) {
      Map<String, String> response = new HashMap<>();
      response.put("error", "Conflict");
      response.put("message", "Region with the same name already exists");
      return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    Region savedRegion = regionRepository.save(region);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedRegion);
  }
}

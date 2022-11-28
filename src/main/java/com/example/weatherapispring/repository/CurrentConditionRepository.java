package com.example.weatherapispring.repository;

import com.example.weatherapispring.model.entity.CurrentCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentConditionRepository extends JpaRepository<CurrentCondition, Long> {
}

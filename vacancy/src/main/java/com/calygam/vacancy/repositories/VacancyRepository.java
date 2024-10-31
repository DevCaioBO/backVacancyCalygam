package com.calygam.vacancy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calygam.vacancy.models.VacancyModel;

public interface VacancyRepository extends JpaRepository<VacancyModel,Integer> {
    
}

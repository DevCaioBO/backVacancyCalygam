package com.calygam.vacancy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calygam.vacancy.DTOS.VacancyDTO;
import com.calygam.vacancy.models.VacancyModel;
import com.calygam.vacancy.models.vacancyModel;
import com.calygam.vacancy.repositories.VacancyRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RestController
@RequestMapping("/crud")

public class VacancyController {

    @Autowired
    private VacancyRepository repository;
    

@GetMapping("vacancy")
    public ResponseEntity<?> vacancyGet() {
        List<VacancyModel> vacancyModel = repository.findAll();
        return ResponseEntity.status(201).body(vacancyModel);
    }

@PostMapping("vacancy")
public ResponseEntity<?> vacancyPost(@ModelAttribute VacancyDTO vacancyDTO) {
    
    VacancyModel vacancyModel = new VacancyModel();

    vacancyModel.setDateCourse(vacancyDTO.dateCourse());
    vacancyModel.setNameCourse(vacancyDTO.nameCourse());
    vacancyModel.setStageCourse(vacancyDTO.stageCourse());

    repository.save(vacancyModel);
    
    return ResponseEntity.status(201).body(vacancyModel);
}

@PutMapping("vacancy/{id}")
public  ResponseEntity<?> vacancyPut(@PathVariable Integer id, @RequestBody VacancyDTO vacancyDTO) {
    VacancyModel vacancyModel = repository.findById(id).get();
    vacancyModel.updateVacancyDTO(vacancyDTO);
    repository.save(vacancyModel);
    
    
    return ResponseEntity.status(200).body("Modificado com sucesso!");

    
   
}




@DeleteMapping("vacancy/{id}")
public  ResponseEntity<?> vacancyDelete(@PathVariable Integer id) {
     repository.deleteById(id);
    return ResponseEntity.status(200).body("Modificado com sucesso!");

    
   
}
}






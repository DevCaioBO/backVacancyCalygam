package com.calygam.vacancy.models;

import java.sql.Date;

import com.calygam.vacancy.DTOS.VacancyDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="course")
@Table(name="course")
public class VacancyModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="dateCourse")
    private Date dateCourse;

    @Column(name="nameCourse")
    private String nameCourse;

    @Column(name="stageCourse")
    private String stageCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Date dateCourse) {
        this.dateCourse = dateCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getStageCourse() {
        return stageCourse;
    }

    public void setStageCourse(String stageCourse) {
        this.stageCourse = stageCourse;
    }

    public void updateVacancyDTO(VacancyDTO vacancyDTO) {
        this.dateCourse = vacancyDTO.dateCourse();
        this.nameCourse = vacancyDTO.nameCourse();
        this.stageCourse = vacancyDTO.stageCourse();
        // TODO Auto-generated method stub
        
    }

    
}

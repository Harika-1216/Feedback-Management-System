package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.Course;

public interface ICourseRepository extends JpaRepository<Course,Integer> {

}

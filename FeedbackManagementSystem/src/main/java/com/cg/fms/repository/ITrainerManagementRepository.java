package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.Employee;

public interface ITrainerManagementRepository extends JpaRepository<Employee,Integer> {

}

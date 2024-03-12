package com.mycompany.jpa.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jpa.entity.*;

@Repository
public interface EmployeeCrud extends JpaRepository<EmployeeEntity, Long>{
	
	

}

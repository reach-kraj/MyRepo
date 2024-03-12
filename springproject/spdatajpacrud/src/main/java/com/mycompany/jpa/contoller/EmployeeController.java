package com.mycompany.jpa.contoller;

import org.springframework.web.bind.annotation.RestController;

import com.mycompany.jpa.business.EmployeeBusiness;
import com.mycompany.jpa.entity.EmployeeEntity;

import java.util.List;

import jakarta.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeBusiness empBusiness;
	
	@RequestMapping("/save")
	public String save() {
		String msg = empBusiness.save();
		return msg;
	}
	
	@RequestMapping("/saveemp/fname/{fname}")
	public String saveEmp(@PathVariable String fname) {
		String msg = empBusiness.save(fname);
		return msg;
	}
	
	
	@PostMapping(path = "/saveEmpPost")
	public String saveEmpPost(@Valid @RequestBody EmployeeEntity empObj) {
		String msg = empBusiness.saveEmployee(empObj);
		return msg;
	}
	
	@RequestMapping("/findall")
	public List saveFindAll() {
		return empBusiness.findAll();
		//return "Welcome from boot";
	}
	
	@DeleteMapping("/remove/id/{id}")
	public String removeEmp(@PathVariable Long id) {
		String msg = empBusiness.remove(id);
		return msg;
	}


	@RequestMapping("/savedept/name/{name}")
	public String saveDept(@PathVariable String name) {
		String msg = empBusiness.saveDept(name);
		return msg;
	}
	
	@GetMapping("/transfer")
	ResponseEntity<String> transfer() {
	    //return new ResponseEntity<>("Transfer Completed", HttpStatus.OK);
		return new ResponseEntity<>("Transfer failed", HttpStatus.BAD_REQUEST);
	}
}

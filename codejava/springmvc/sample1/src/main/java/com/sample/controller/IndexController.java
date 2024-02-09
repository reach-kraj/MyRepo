package com.sample.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Course;

@Controller
@Scope("prototype")
public class IndexController {

	@GetMapping("/2")
	 public ResponseEntity < ? > getSimpeResponse() throws InterruptedException {

	  Thread.sleep(3000);
	  return ResponseEntity.ok("Welcome to Infograss");
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

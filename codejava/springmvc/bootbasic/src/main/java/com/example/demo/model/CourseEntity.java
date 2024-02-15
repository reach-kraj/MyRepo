package com.example.demo.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "course", uniqueConstraints = 
	    @UniqueConstraint(columnNames = "courseid"))
	    
	    public class CourseEntity implements Serializable {

		@Serial
		private static final long serialVersionUID = -1798070786993154676L;


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "courseid")
		private Integer courseid;

		@Column(name = "coursename")
		private String coursename;

		@Column(name = "coursecategory")
		private String coursecategory;

		@Column(name = "credits")
		private String credits;

		public Integer getEmployeeId() {	
			return courseid;	}

		public void setCourseId(Integer employeeid) {
			this.courseid = courseid;
		}

		public Integer getCourseid() {
			return courseid;
		}

		public void setCourseid(Integer courseid) {
			this.courseid = courseid;
		}

		public String getCoursecategory() {
			return coursecategory;
		}

		public void setCoursecategory(String coursecategory) {
			this.coursecategory = coursecategory;
		}

		public String getCredits() {
			return credits;
		}

		public void setCredits(String credits) {
			this.credits = credits;
		}

		public void setCoursename(String coursename) {
			this.coursename = coursename;
		}

		
	}

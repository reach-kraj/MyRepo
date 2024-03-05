package com.demo.onetomany.dto;

import java.io.Serializable;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssoUserEntity")
@Table(name = "USER_1_M", uniqueConstraints = {
    @UniqueConstraint(columnNames = "USER_ID"),
    })
public class UserEntityOnetoMany implements Serializable {
	 private static final long serialVersionUID = -1798070786993154676L;
	 
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "USER_ID", unique = true, nullable = false)
	  private Integer user_Id;

	  

	  @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	  private String first_Name;

	  @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	  private String last_Name;
	  
	  @Column(name = "PASSWORD", unique = false, nullable = false, length = 100)
	  private String password;
	  
	  @OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="USER_ID")
		private Set<MovieEntityOnetoMany> movieList;

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<MovieEntityOnetoMany> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<MovieEntityOnetoMany> movieList) {
		this.movieList = movieList;
	}

	
}

	
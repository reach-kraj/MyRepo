package com.demo.onetomany.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssoMovieEntity")
@Table(name = "MOVIE_1_M", uniqueConstraints = {@UniqueConstraint(columnNames = "MOVIE_ID")})
public class MovieEntityOnetoMany implements Serializable {
	
	@Serial
	  private static final long serialVersionUID = -6790693372846798580L;
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "MOVIE_ID", unique = true, nullable = false)
	  private Integer movie_Id;
	
	 @Column(name = "MOVIE_NAME", nullable = false, length = 100)
	  private String movie_Name;
	 
	 
	  
	  @Column(name = "MOVIE_PRICE", nullable = false, length = 100)
	  private String movie_Price;
	 
	  @Column(name = "DESC", nullable = false, length = 100)
	  private String desc;
	 
	  @Column(name = "Date_Time", nullable = false, length = 100)
	  private String date_Time;

	public Integer getMovie_Id() {
		return movie_Id;
	}

	public void setMovie_Id(Integer movie_Id) {
		this.movie_Id = movie_Id;
	}

	public String getMovie_Name() {
		return movie_Name;
	}

	public void setMovie_Name(String movie_Name) {
		this.movie_Name = movie_Name;
	}

	public String getMovie_Price() {
		return movie_Price;
	}

	public void setMovie_Price(String movie_Price) {
		this.movie_Price = movie_Price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate_Time() {
		return date_Time;
	}

	public void setDate_Time(String date_Time) {
		this.date_Time = date_Time;
	}
}

	
package com.demo.dto;

import java.io.Serial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Movie", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "MOVIE_ID"),
	    @UniqueConstraint(columnNames = "MOVIE_NAME") })

public class MovieEntity {
	
	@Serial
	private static final long serialVersionUID = -1798070786993154676L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "MOVIE_ID")
	private Integer movie_id;
	
	
	@Column(name = "MOVIE_NAME")
	private String movie_name;
	
	@Column(name ="DESC")
	private String desc;
	
	@Column(name ="DATE_TIME")
	private String Date_time;
	
	@Column(name ="MOVIE_PRICE")
	private String movie_price;
	

	public Integer getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}


	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getDate_time() {
		return Date_time;
	}


	public void setDate_time(String date_time) {
		Date_time = date_time;
	}


	public String getMovie_price() {
		return movie_price;
	}


	public void setMovie_price(String movie_price) {
		this.movie_price = movie_price;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

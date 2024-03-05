package com.demo.onetoone.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "ForeignKeyAssUserEntity")
@Table(name = "User_1_1", uniqueConstraints = {
    @UniqueConstraint(columnNames = "USER_ID"),
    })
public class UserEntity implements Serializable {
	 private static final long serialVersionUID = -1798070786993154676L;

	  public UserEntity() {}

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

	  @OneToOne
	  @JoinColumn(name = "MOVIE_ID")
	  @OrderBy("first_Name ASC, last_name DESC")
	  private MovieEntity movie;

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_id) {
		this.user_Id = user_id;
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

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
}
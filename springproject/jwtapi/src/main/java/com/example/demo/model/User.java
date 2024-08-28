package com.example.demo.model;


	import jakarta.persistence.*;

	@Entity
	@Table(name = "users")
	public class User {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    private String first_Name;
	    private String last_Name;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		

	   
	}

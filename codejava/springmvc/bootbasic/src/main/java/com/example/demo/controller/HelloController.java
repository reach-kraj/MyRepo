package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.CourseEntity;
import com.example.demo.model.Student;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.hibernate.SessionFactory;


@RestController
@RequestMapping("hello")
public class HelloController {

	/*
	 * @Value("${dbservername}") private String dbservername;
	 * 
	 * @Value("${dbserveruserid}") private String dbserveruserid;
	 */

    @GetMapping("/abc/{name}")
    public @ResponseBody String helloUser(@PathVariable String name) {
		/*
		 * System.out.println(dbservername); System.out.println(dbserveruserid);
		 */
        return "Hello, welcome " + name;
    }

    @GetMapping("/helloworld")
    public @ResponseBody String helloWorld() {
        return "Hello, Java world!";
    }

    @GetMapping("/getStudents")
    public @ResponseBody String studentList() {
        // Mock data
        Student s1 = new Student();
        s1.setStudentId(123);
        s1.setDepartmentName("ECE");
        s1.setName("John");

        Student s2 = new Student();
        s2.setStudentId(124);
        s2.setDepartmentName("ECE");
        s2.setName("Lisa");

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        Gson gson = new Gson();
        String jsonArray = gson.toJson(list);
        return jsonArray;
    }

    @GetMapping("/getCourse/{courseid}")
    public @ResponseBody String courseList(@PathVariable String courseid) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "Root");
            
            
            // String QUERY = "SELECT * FROM course";
            // Create a SQL query
            String QUERY = "SELECT * FROM course WHERE courseid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(QUERY);
            preparedStatement.setString(1, courseid);

            // Execute the prepared statement
            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Course> listcourse = new ArrayList<>();

            // Iterate through the result set and create course objects
            while (rs.next()) {
            	 // Retrieve by column name
	            String courseId = rs.getString("courseid");
	            String coursename = rs.getString("coursename");
	            String coursecategory = rs.getString("coursecategory");
	            String credits = rs.getString("credits");

                Course courseobj = new Course();
                courseobj.setCourseid(courseId);
                courseobj.setCoursename(coursename);
                courseobj.setCoursecategory(coursecategory);
                courseobj.setCredits(credits);

                listcourse.add(courseobj);
            }

            // Convert the course list to JSON using Gson
            Gson gson = new Gson();
            JsonElement courseList = gson.toJsonTree(listcourse);

            // Close the database connection
            con.close();

            return courseList.toString();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Error fetching course data: " + e.getMessage();
        }
    }
    @PutMapping("/updateCourse/{courseid}")
    public ResponseEntity<String> updateCourse(@PathVariable String courseid, @RequestBody String coursename) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "Root");

            
            String UPDATE_SQL = "UPDATE course SET coursename = ? WHERE courseid = ?";

            
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, coursename);
            preparedStatement.setString(2, courseid);

            
            int rowsAffected = preparedStatement.executeUpdate();

            
            con.close();

            if (rowsAffected > 0) {
                return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No course found with the given courseid", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error updating course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertCourse")
    public @ResponseBody String insertCourse (@RequestBody Course course) {
    	try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "Root");

            
            String INSERT_SQL = "insert into course(courseid,coursename,coursecategory,credits) values (?, ?, ?, ?) ";
            
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, course.getCourseid());
            preparedStatement.setString(2, course.getCoursename());
            preparedStatement.setString(3, course.getCoursecategory());
            preparedStatement.setString(4, course.getCredits());
            
            preparedStatement.executeUpdate();
            
            
            con.close();


    	return "Course Completed Successfully.";
    }catch (Exception e) {
        e.printStackTrace();
        return ("Error updating course: " + e.getMessage());
    }
    }
    
    
    @PostMapping("/addCoursehibernate")
    public @ResponseBody String addMoviehibernate() {
    	SessionFactory sessionFactory = getSessionFactory(null);
		Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
    	//Session session = ((org.hibernate.SessionFactory);
		session.beginTransaction();

		
		CourseEntity obj = new CourseEntity();
		//obj.setCourseid("105");
		obj.setCoursename("DBMS");
		obj.setCoursecategory("Introduction to Programming");
		obj.setCredits("5");

		session.persist(obj);
		
		
		session.getTransaction().commit();
		System.out.println("Generated course id is : "+obj.getCourseid());
		//HibernateUtil.shutdown();
		//Object clone = sessionFactory.clone();
		sessionFactory.close();
        return "hello";
	}	
	

    public static SessionFactory getSessionFactory(Class[] classes) {
		Metadata metadata;
		StandardServiceRegistry standardRegistry
        = new StandardServiceRegistryBuilder()
          .configure()
          .build();

		if(classes == null) {
			metadata = new MetadataSources(standardRegistry)
						.getMetadataBuilder()
						.build();
		} else {
			MetadataSources metadatasources = new MetadataSources(standardRegistry);
			for(int index=0; index<classes.length; index++) {
				metadatasources.addAnnotatedClass(classes[index]);
			}
			metadata = metadatasources.getMetadataBuilder()
	          .build();
			 
		}

    SessionFactory sessionFactory =  metadata.getSessionFactoryBuilder().build();
    return sessionFactory;
    
	}
	
    
    @DeleteMapping("deleteCourse/{courseid}")
    public String deleteCourse(@PathVariable String courseid) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "Root");

          String deleteQuery ="delete from course where courseid = ?";
          PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
          preparedStatement.setString(1, courseid);
          preparedStatement.executeUpdate();
          con.close();
          return "Course delete successfully";
        }catch (Exception e) {
            e.printStackTrace();
            return ("Error inserting  course data: " + e.getMessage());
        }
    }
    
}
    
   
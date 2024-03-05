package com.demo;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.UniqueConstraint;
import javax.persistence.PersistenceException;

import com.demo.dto.EmployeeEntity;
import com.demo.dto.MovieEntity;
import com.demo.dto.Student;
import com.demo.manytomany.dto.ReaderEntity;
import com.demo.manytomany.dto.SubscriptionEntity;
import com.demo.onetomany.dto.AccountEntityOneToMany;
import com.demo.onetomany.dto.EmployeeEntityOneToMany;
import com.demo.onetomany.dto.MovieEntityOnetoMany;
//import com.demo.onetomany.dto.MovieEntityonetomany;
import com.demo.onetomany.dto.UserEntityOnetoMany;
//import com.demo.onetomany.dto.UserEntityonetomany;
import com.demo.onetoone.dto.UserEntity;
import com.demo.dto.User;
import org.hibernate.exception.SQLGrammarException;
import jakarta.persistence.Query;
import jakarta.persistence.Table;

public class TestHibernate {
	public static SessionFactory getSessionFactory(Class[] classes) {
		Metadata metadata;
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();

		if (classes == null) {
			metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		} else {
			MetadataSources metadatasources = new MetadataSources(standardRegistry);
			for (int index = 0; index < classes.length; index++) {
				metadatasources.addAnnotatedClass(classes[index]);
			}
			metadata = metadatasources.getMetadataBuilder().build();

		}

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;

	}

	public static void testBasic() {

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("Tim");
		emp.setLastName("Cook");
		session.persist(emp);
		//session.save(emp);
		
	
		

		
		 session.getTransaction().commit();
		 System.out.println("Generated emp id is : " + emp.getEmployeeId()); 
		 //HibernateUtil.shutdown(); 
		 sessionFactory.close();
		 

	}
	
	public static void MovieBasicHql() {

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String insertHql = "INSERT INTO MovieEntity (movie_name, movie_id, desc, date_time,movie_price) " +
                "VALUES (:movie_name, :movie_id, :desc, :date_time,:movie_price)";
		
		Query insertQuery = session.createQuery(insertHql);
		
		insertQuery.setParameter("movie_name","kgf");
		//insertQuery.setParameter("movie_id","kgf");
		insertQuery.setParameter("movie","kgf");
		insertQuery.setParameter("movie_name","kgf");
		insertQuery.setParameter("movie_name","kgf");
		
		
		
	}

	
	

	public static void movieBasic() {

		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		MovieEntity MovieEntity = new MovieEntity();
		// MovieEntity .setMovie_id("10091");
		MovieEntity.setDate_time("2021-03-12  23:12:00");
		MovieEntity.setMovie_price("450");
		MovieEntity.setDesc("COMEDY");
		MovieEntity.setMovie_name("JILLA");

		session.persist(MovieEntity);
		
		MovieEntity movie = (MovieEntity)session.get(MovieEntity.class, MovieEntity.getMovie_id());
		movie.setMovie_name("cwc");
		session.update(movie);
		session.getTransaction().commit();
		System.out.println("Generated emp id is : " + MovieEntity.getMovie_id());
		// HibernateUtil.shutdown();
		//sessionFactory.close();
		
		session.get(MovieEntity.class,MovieEntity.getMovie_id());
		if(MovieEntity!=null) {
			System.out.println(MovieEntity.getMovie_name());
			System.out.println(MovieEntity.getMovie_price());
			System.out.println(MovieEntity.getDate_time());
			System.out.println(MovieEntity.getDesc());
			
		}
		//session.getTransaction().commit();
		System.out.println("Updated Successfully");
		
		

		
		
		sessionFactory.close();

	}

	public static void testMapping() {

		Student student = new Student();

		// Setting the object properties.
		student.setFirstName("John");
		student.setLastName("Smith");
		student.setClassName("SOME DEGREE");
		student.setRollNo("SOMEDEGREE123");
		student.setAge(21);

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(student);
	     
		 
		session.getTransaction().commit();
		System.out.println("Generated student id is : " + student.getStudentId());
		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void UserMapping() {

		User user = new User();

		// Setting the object properties.
		// user.setUserid("123");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setPassWord("SOME DEGREE");

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		// Session entityManager = null;
		// entityManager.persist(user);
		session.persist(user);
		session.getTransaction().commit();
		System.out.println("Generated user id is : " + user.getUserId());
		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void testOneToOne() {

		com.demo.onetoone.dto.AccountEntity account = new com.demo.onetoone.dto.AccountEntity();
		account.setAccountNumber("123-345-65454");

		// Add new Employee object
		com.demo.onetoone.dto.EmployeeEntity emp = new com.demo.onetoone.dto.EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		Class[] classes = new Class[2];
		classes[0] = com.demo.onetoone.dto.AccountEntity.class;
		classes[1] = com.demo.onetoone.dto.EmployeeEntity.class;
		// Session session = getSessionFactory(classes).openSession();
		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(account);
		System.out.println("One to one mapping: account.getAccountId() " + account.getAccountId());
		// session.getTransaction().commit();
		emp.setAccount(account);
		System.out.println("One to one mapping: emp.getEmployeeId() " + emp.getEmployeeId());
		session.persist(emp);
		System.out.println("One to one mapping: emp.getEmployeeId() " + emp.getEmployeeId());
		System.out.println("One to one mapping: account.getAccountId() " + account.getAccountId());

		session.getTransaction().commit();

		System.out.println("One to one mapping: emp.getEmployeeId() " + emp.getEmployeeId());
		System.out.println("One to one mapping: account.getAccountId() " + account.getAccountId());

		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void userOneToOne() {

		com.demo.onetoone.dto.UserEntity user = new com.demo.onetoone.dto.UserEntity();
		// user.setUser_Id(123);
		user.setFirst_Name("reena");
		user.setLast_Name("porsiya");
		user.setPassword("reena");

		// Add new Employee object
		com.demo.onetoone.dto.MovieEntity emp = new com.demo.onetoone.dto.MovieEntity();
		// emp.setEmail("demo-user@mail.com");
		// emp.setMovie_Id(123);
		emp.setMovie_Name("user");
		emp.setMovie_Price("230");
		emp.setDate_Time("12:04:00");
		emp.setDesc("reena");

		Class[] classes = new Class[2];
		classes[0] = com.demo.onetoone.dto.UserEntity.class;
		classes[1] = com.demo.onetoone.dto.MovieEntity.class;
		// Session session = getSessionFactory(classes).openSession();
		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(user);
		System.out.println("One to one mapping: user.getUserId() " + user.getUser_Id());
		// session.getTransaction().commit();
		emp.setUser(user);
		System.out.println("One to one mapping: emp.getMovieId() " + emp.getMovie_Id());
		session.persist(emp);
		System.out.println("One to one mapping: emp.getMovieId() " + emp.getMovie_Id());
		System.out.println("One to one mapping: user.getUserId() " + user.getUser_Id());

		session.getTransaction().commit();

		System.out.println("One to one mapping: emp.getMovieId() " + emp.getMovie_Id());
		System.out.println("One to one mapping: account.getuserId() " + user.getUser_Id());

		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void testOneToMany() {

		Class[] classes = new Class[2];
		classes[0] = com.demo.onetomany.dto.AccountEntityOneToMany.class;
		classes[1] = com.demo.onetomany.dto.EmployeeEntityOneToMany.class;
		// Session session = getSessionFactory(classes).openSession();
		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();

		AccountEntityOneToMany account1 = new AccountEntityOneToMany();
		account1.setAccountNumber("Account detail 1");

		AccountEntityOneToMany account2 = new AccountEntityOneToMany();
		account2.setAccountNumber("Account detail 2");

		AccountEntityOneToMany account3 = new AccountEntityOneToMany();
		account3.setAccountNumber("Account detail 3");

		// Add new Employee object
		EmployeeEntityOneToMany employee = new EmployeeEntityOneToMany();
		employee.setEmail("demo-user-first@mail.com");
		employee.setFirstName("demo-one");
		employee.setLastName("user-one");

		Set<AccountEntityOneToMany> accountList = new HashSet<AccountEntityOneToMany>();
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);

		employee.setAccounts(accountList);

		session.beginTransaction();
		// Save Employee
		session.persist(employee);
		session.flush();
		session.getTransaction().commit();

		// employee.getAccounts().remove(account3);
		// session.flush();
		// session.getTransaction().commit();

		// session.remove(employee);
		// session.flush();
		// session.getTransaction().commit();

		sessionFactory.close();

	}

	public static void usertestOneToMany() {

		Class[] classes = new Class[2];
		classes[0] = com.demo.onetomany.dto.MovieEntityOnetoMany.class;
		classes[1] = com.demo.onetomany.dto.UserEntityOnetoMany.class;
		// Session session = getSessionFactory(classes).openSession();
		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();

		MovieEntityOnetoMany movie1 = new MovieEntityOnetoMany();

		movie1.setMovie_Name("user");
		movie1.setMovie_Price("230");
		movie1.setDate_Time("12:04:00");
		movie1.setDesc("reena");

		MovieEntityOnetoMany movie2 = new MovieEntityOnetoMany();
		movie2.setMovie_Name("user");
		movie2.setMovie_Price("230");
		movie2.setDate_Time("12:04:00");
		movie2.setDesc("reena");

		MovieEntityOnetoMany movie3 = new MovieEntityOnetoMany();
		movie3.setMovie_Name("user");
		movie3.setMovie_Price("230");
		movie3.setDate_Time("12:04:00");
		movie3.setDesc("reena");

		// Add new Employee object
		UserEntityOnetoMany user = new UserEntityOnetoMany();
		user.setFirst_Name("reena");
		user.setLast_Name("porsiya");
		user.setPassword("reena");

		Set<MovieEntityOnetoMany> movieList = new HashSet<MovieEntityOnetoMany>();
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);

		user.setMovieList(movieList);

		session.beginTransaction();
		// Save Employee
		session.persist(user);
		session.flush();
		session.getTransaction().commit();

		// employee.getAccounts().remove(account3);
		// session.flush();
		// session.getTransaction().commit();

		// session.remove(employee);
		// session.flush();
		// session.getTransaction().commit();

		sessionFactory.close();

	}

	public static void testManyToMany() {

		Class[] classes = new Class[2];
		classes[0] = com.demo.manytomany.dto.ReaderEntity.class;
		classes[1] = com.demo.manytomany.dto.SubscriptionEntity.class;
		// Session session = getSessionFactory(classes).openSession();
		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		SubscriptionEntity subOne = new SubscriptionEntity();
		subOne.setSubscriptionName("Entertainment");

		SubscriptionEntity subTwo = new SubscriptionEntity();
		subTwo.setSubscriptionName("Horror");

		Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
		subs.add(subOne);
		subs.add(subTwo);

		// Add readers
		ReaderEntity readerOne = new ReaderEntity();
		readerOne.setEmail("demo-user1@mail.com");
		readerOne.setFirstName("demo");
		readerOne.setLastName("user");

		ReaderEntity readerTwo = new ReaderEntity();
		readerTwo.setEmail("demo-user2@mail.com");
		readerTwo.setFirstName("demo");
		readerTwo.setLastName("user");

		Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		readers.add(readerOne);
		readers.add(readerTwo);

		readerOne.setSubscriptions(subs);
		readerTwo.setSubscriptions(subs);

		session.persist(readerOne);
		session.persist(readerTwo);

		session.getTransaction().commit();
		sessionFactory.close();

	}

	public static void testValidations() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Student student = new Student();

		// Setting the object properties.
		// student.setFirstName("John");
		student.setLastName("Smith");
		student.setClassName("SOME DEGREE");
		student.setRollNo("SOMEDEGREE123");
		student.setAge(21);

		Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Student> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void UserValidations() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		User user = new User();

		// Setting the object properties.
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setPassWord("SOME DEGREE");

		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<User> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}

		// Session session = HibernateUtil.getSessionFactory().openSession();
		SessionFactory sessionFactory = getSessionFactory(null);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		// HibernateUtil.shutdown();
		sessionFactory.close();

	}

	public static void testNamedQueries() {

		Class[] classes = new Class[1];
		classes[0] = com.demo.named.dto.DepartmentEntity.class;

		SessionFactory sessionFactory = getSessionFactory(classes);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		com.demo.named.dto.DepartmentEntity d1 = new com.demo.named.dto.DepartmentEntity();
		d1.setName("HR");

		com.demo.named.dto.DepartmentEntity d2 = new com.demo.named.dto.DepartmentEntity();
		d2.setName("Finance");

		session.persist(d1);
		session.persist(d2);
		session.flush();
		session.getTransaction().commit();

		Query query = session.createNamedQuery(com.demo.named.dto.DepartmentEntity.QUERY_GET_DEPARTMENT_BY_ID)
				.setParameter("id", 1);

		com.demo.named.dto.DepartmentEntity dept = (com.demo.named.dto.DepartmentEntity) query.getSingleResult();
		System.out.println(dept.getName());

		Query query1 = session
				.createNamedQuery(com.demo.named.dto.DepartmentEntity.NATIVE_QUERY_UPDATE_DEPARTMENT_BY_ID)
				.setParameter("name", "SUPPORT").setParameter("id", 1);

		session.beginTransaction();
		query1.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();

		session.beginTransaction();
		Query query2 = session.createNamedQuery(com.demo.named.dto.DepartmentEntity.QUERY_GET_DEPARTMENT_BY_ID)
				.setParameter("id", 1);

		com.demo.named.dto.DepartmentEntity dept1 = (com.demo.named.dto.DepartmentEntity) query2.getSingleResult();
		System.out.println(dept1.getName());

		String hql = "from DepartmentEntity where id > 1";
		Query query3 = session.createQuery(hql);
		query3.setMaxResults(2);
		List<com.demo.named.dto.DepartmentEntity> list = query3.getResultList();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			com.demo.named.dto.DepartmentEntity deptartment = (com.demo.named.dto.DepartmentEntity) iter.next();
			System.out.println("list is" + deptartment.getName());
		}

		// session.getTransaction().begin();

		// Criteria queries using JPA.
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<com.demo.named.dto.DepartmentEntity> criteriaQuery = builder
				.createQuery(com.demo.named.dto.DepartmentEntity.class);
		Root<com.demo.named.dto.DepartmentEntity> root = criteriaQuery.from(com.demo.named.dto.DepartmentEntity.class);
		List<Order> orderList = new ArrayList();
		orderList.add(builder.asc(root.get("name")));

		TypedQuery<com.demo.named.dto.DepartmentEntity> queryd = session
				.createQuery(criteriaQuery.select(root).orderBy(orderList));
		List<com.demo.named.dto.DepartmentEntity> listd = queryd.getResultList();
		session.getTransaction().commit();
		Iterator<com.demo.named.dto.DepartmentEntity> iterD = listd.iterator();
		System.out.println("----------------");
		while (iterD.hasNext()) {
			com.demo.named.dto.DepartmentEntity de = (com.demo.named.dto.DepartmentEntity) iterD.next();
			System.out.println(de.getName());
		}

		System.out.println("---------get method");
		com.demo.named.dto.DepartmentEntity deptGet = (com.demo.named.dto.DepartmentEntity) session
				.get(com.demo.named.dto.DepartmentEntity.class, new Long(2));
		System.out.println("Dept ID= " + deptGet.getId());

		System.out.println("---------load method");
		com.demo.named.dto.DepartmentEntity deptLoad = (com.demo.named.dto.DepartmentEntity) session
				.load(com.demo.named.dto.DepartmentEntity.class, new Long(2));
		System.out.println("Dept ID= " + deptLoad.getId());

		sessionFactory.close();

	}

	public static void testCriteriaQueries() {

	}

	public static void main(String[] args) {
		 //testBasic();
		// testMapping();
		// testValidations();
		// testOneToOne();
		// testOneToMany();
		// testManyToMany();
		// testNamedQueries();
		// UserValidations();

		movieBasic();
		// UserMapping();
		// testuserValidations();

		// userOneToOne();
		//usertestOneToMany();

	}

}

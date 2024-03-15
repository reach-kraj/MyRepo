package net.collection.bookpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.collection.bookpro.model.Book;


@Controller
@RequestMapping(value="/")
public class HomeController {

	private static final String url = "jdbc:mysql://localhost:3306/bookdb";
	private static final String username = "root";
	private static final String password = "root";

	@GetMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}
	@GetMapping("/add")
	public String addbooks() 
	{
		return "insert";	
	}
	@GetMapping("/search")
	public String search() 
	{
		return "search";	
	}

	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}
	@PostMapping("/addbook")
	public  String insertbook(@RequestParam("bookid") int bookid,
			@RequestParam("bookname") String bookname,
			@RequestParam("bookauthor") String bookauthor,
			@RequestParam("bookprint") String bookprint, Model model) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, username, password)) {

				String sql = "INSERT INTO bookcoll(bookid, bookname, bookauthor, bookprint) values (?, ?, ?, ?)";
				try (PreparedStatement Statement = con.prepareStatement(sql)) {
					Statement.setInt(1, bookid);
					Statement.setString(2, bookname);
					System.out.println("2");
					Statement.setString(3, bookauthor);
					Statement.setString(4, bookprint);
					int rowAffected= Statement.executeUpdate();
					if(rowAffected>0) {
						model.addAttribute("message","book Added Successfully");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@GetMapping("/list")
	public String listbook(Model model) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String QUERY = "SELECT * FROM bookcoll";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			ArrayList listbook = new ArrayList();

			while (rs.next()) {
				// Retrieve by column name
				int bookId = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String bookauthor = rs.getString("bookauthor");
				String bookprint = rs.getString("bookprint");

				Book bookobj = new Book();

				bookobj.setBookid(bookId);
				bookobj.setBookname(bookname);
				bookobj.setBookauthor(bookauthor);
				bookobj.setBookprint(bookprint);

				listbook.add(bookobj);
			}

			model.addAttribute("listbook",listbook);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "listbook";
	}

	@GetMapping("/searchresult")
	public String searchResult(@RequestParam("bookid") int bookId, Model model) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, username, password)) {
				String SELECT_SQL = "SELECT * FROM bookcoll WHERE bookid = ?";

				try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_SQL)) {
					preparedStatement.setInt(1, bookId);

					try (ResultSet resultSet = preparedStatement.executeQuery()) {
						if (resultSet.next()) {
							String bookname = resultSet.getString("bookname");
							String bookauthor = resultSet.getString("bookauthor");
							String bookprint = resultSet.getString("bookprint");

							model.addAttribute("bookid", bookId);
							model.addAttribute("bookname", bookname);
							model.addAttribute("bookauthor", bookauthor);
							model.addAttribute("bookprint", bookprint);

							return "searchedbook";
						} else {
							model.addAttribute("message", "Book not found for ID: " + bookId);

						}
					}
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Error occurred while searching for book: " + e.getMessage());
		}
		return "bookerror";
	}

	@PostMapping("/deletebook")
	public String deleteBook(@RequestParam("bookid") int bookid,Model model) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection connection = DriverManager.getConnection(url, username, password)) {
				String sql = "DELETE FROM bookcoll WHERE bookid = ?";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setInt(1, bookid);
					statement.executeUpdate();

					model.addAttribute("message","Deleted Added Successfully");
				}
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "success"; 
	}

	@PostMapping("/editbookinsert")
	public String editBook(@RequestParam("bookid") int bookid,
			@RequestParam("bookname") String bookname,
			@RequestParam("bookauthor") String bookauthor,
			@RequestParam("bookprint") String bookprint, Model model) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection connection = DriverManager.getConnection(url, username, password)) {
				String sql = "UPDATE bookcoll SET bookname = ?, bookauthor = ?, bookprint = ? WHERE bookid = ?";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setString(1, bookname);
					statement.setString(2, bookauthor);
					statement.setString(3, bookprint);
					statement.setInt(4, bookid);

					statement.executeUpdate();

					model.addAttribute("message","Updated Added Successfully");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@GetMapping("/editbook")
	public String showEdit(@RequestParam("bookid") int bookid, Model model) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection connection = DriverManager.getConnection(url, username, password)) {
				String sql = "SELECT * FROM bookcoll WHERE bookid = ?";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setInt(1, bookid);
					ResultSet resultSet = statement.executeQuery();
					if (resultSet.next()) {
						String bookname = resultSet.getString("bookname");
						String bookauthor = resultSet.getString("bookauthor");
						String bookprint = resultSet.getString("bookprint");

						model.addAttribute("bookid", bookid);
						model.addAttribute("bookname", bookname);
						model.addAttribute("bookauthor", bookauthor);
						model.addAttribute("bookprint", bookprint);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "edit";
	}

	@GetMapping("/editlist")
	public String editbook(Model model) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String QUERY = "SELECT * FROM bookcoll";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			ArrayList editbook = new ArrayList();

			while (rs.next()) {
				// Retrieve by column name
				int bookId = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String bookauthor = rs.getString("bookauthor");
				String bookprint = rs.getString("bookprint");

				Book bookobj = new Book();

				bookobj.setBookid(bookId);
				bookobj.setBookname(bookname);
				bookobj.setBookauthor(bookauthor);
				bookobj.setBookprint(bookprint);

				editbook.add(bookobj);
			}

			model.addAttribute("edited",editbook);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "edited";
	}

	@GetMapping("/deletelist")
	public String deletebook(Model model) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String QUERY = "SELECT * FROM bookcoll";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			ArrayList deletebook = new ArrayList();

			while (rs.next()) {
				// Retrieve by column name
				int bookId = rs.getInt("bookid");
				String bookname = rs.getString("bookname");
				String bookauthor = rs.getString("bookauthor");
				String bookprint = rs.getString("bookprint");

				Book bookobj = new Book();

				bookobj.setBookid(bookId);
				bookobj.setBookname(bookname);
				bookobj.setBookauthor(bookauthor);
				bookobj.setBookprint(bookprint);

				deletebook.add(bookobj);
			}

			model.addAttribute("delete",deletebook);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

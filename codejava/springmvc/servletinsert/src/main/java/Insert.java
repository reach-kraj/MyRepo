

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int age= Integer.parseInt(request.getParameter("age"));
		String mobilenumber=request.getParameter("mobilenumber");
		String email = request.getParameter("email");

		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/servletsample";
			String uname="root";
			String pwd="root";
			con=DriverManager.getConnection(url,uname,pwd);

			String query="Insert into passengerlist(username,firstname,lastname,age,mobilenumber,email)  values(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setInt(4,age);
			ps.setString(5,mobilenumber);
			ps.setString(6, email);
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			if(con!= null){
				try {
//					con.commit();
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

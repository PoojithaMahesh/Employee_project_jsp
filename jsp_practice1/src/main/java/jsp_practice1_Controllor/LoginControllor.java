package jsp_practice1_Controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_practice1_dao.Employeedao;
import jsp_practice1_dto.Employee;
@WebServlet("/login")
public class LoginControllor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	Employee employee=new Employee();
	employee.setEmail(email);
	employee.setPassword(password);
	Employeedao employeedao=new Employeedao();
	Employee employee2=employeedao.getEmployeebyId(email);
	if(employee2.getPassword().equals(password)) {
//		Cookie cookie=new Cookie("name",employee2.getName());
//		resp.addCookie(cookie);
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("name", employee2.getName());
		List<Employee> list=employeedao.getAllEmployee();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}else {
		req.setAttribute("message", "Invalid password");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
		
	}
}
}

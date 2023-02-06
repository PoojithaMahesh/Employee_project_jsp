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

import jsp_practice1_dao.Employeedao;
import jsp_practice1_dto.Employee;
@WebServlet("/edit")
public class EditControllor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String address=req.getParameter("address");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));


	Employee employee=new Employee();
	employee.setId(id);
	employee.setAddress(address);
	employee.setEmail(email);
	employee.setName(name);
	employee.setPassword(password);
	employee.setPhone(phone);
	Employeedao employeedao=new Employeedao();
	Employee savedEmployee=employeedao.updateEmployee(employee);
	if(savedEmployee!=null) {
		List<Employee> list=employeedao.getAllEmployee();
		req.setAttribute("list", list);
		Cookie[] cookies=req.getCookies();
	    String value=null;
	    for(Cookie cookie:cookies) {
	    	if(cookie.getName().equals("name")) {
	    		value=cookie.getValue();
	    	}
	    	
	    }
	    req.setAttribute("name", value);
		
	RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
	dispatcher.forward(req, resp);
	}else {
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
	
	
	
	
	
}
}

package jsp_practice1_Controllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_practice1_dao.Employeedao;
import jsp_practice1_dto.Employee;
@WebServlet("/save")
public class EmployeeControllor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name=req.getParameter("name");
String address=req.getParameter("address");
String email=req.getParameter("email");
String password=req.getParameter("password");
long phone=Long.parseLong(req.getParameter("phone"));


Employee employee=new Employee();
employee.setAddress(address);
employee.setEmail(email);
employee.setName(name);
employee.setPassword(password);
employee.setPhone(phone);
Employeedao employeedao=new Employeedao();
Employee savedEmployee=employeedao.saveEmployee(employee);
if(savedEmployee!=null) {
	req.setAttribute("message", "Successfully signed up");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	dispatcher.forward(req, resp);
}




}
}

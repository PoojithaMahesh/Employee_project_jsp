package jsp_practice1_Controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_practice1_dao.Employeedao;
import jsp_practice1_dto.Employee;
@WebServlet("/delete")
public class DeleteControllor extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Employeedao employeedao=new Employeedao();
	boolean value=employeedao.deleteEmployee(id);
	if(value) {
		List<Employee> list=employeedao.getAllEmployee();
		req.setAttribute("list", list);
	 RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
	 dispatcher.forward(req, resp);
		
	}
}
}

package jsp_practice1_Controllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_practice1_dao.Employeedao;
import jsp_practice1_dto.Employee;
@WebServlet("/update")
public class UpdateControllor extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Employeedao employeedao=new Employeedao();
	Employee employee=employeedao.getStudentById(id);
	if(employee!=null) {
		HttpSession httpSession=req.getSession();
		String  name=(String)httpSession.getAttribute("name");
		if(name!=null) {
			req.setAttribute("employee", employee);
			RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			req.setAttribute("message", "first login to update");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
}

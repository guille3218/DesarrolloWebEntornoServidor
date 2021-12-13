package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOEmployeeImpl daoEmployee = new DAOEmployeeImpl();
		DAOOfficeImpl daoOffice = new DAOOfficeImpl();
		
		ArrayList<Office> offices = (ArrayList) daoOffice.getAllOffices();
		
		ArrayList<Employee> employees =(ArrayList) daoEmployee.getAllEmployee();
		
		request.setAttribute("offices", offices);
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/WEB-INF/view/admin/addEmpleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber")) ;
		String lastName = request.getParameter("lastName");
		String name = request.getParameter("name");
		String extension = request.getParameter("extension");
		String email = request.getParameter("email");
		String puesto = request.getParameter("puesto");
		String oficina = request.getParameter("oficina");
		int jefe = Integer.parseInt(request.getParameter("jefe"));
		
		DAOEmployeeImpl daoEmployee = new DAOEmployeeImpl();
		
		if(daoEmployee.getEmployee(employeeNumber)!=null) {
			request.setAttribute("error", "Ya existe un usuario con ese código");
			doGet(request,response);
			return;
		}else {
			Employee employee = new Employee(employeeNumber,lastName,name,extension,email,oficina,jefe,puesto);
			
			daoEmployee.addEmployee(employee);
			response.sendRedirect(request.getContextPath()+"/Admin/Empleados");
		}
	}

}

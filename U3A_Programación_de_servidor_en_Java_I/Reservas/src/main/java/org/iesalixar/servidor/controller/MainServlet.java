package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Atributos necesarios para validar la contraseña que nos viene del formulario	
		 private static final String PASSWORD_REGEX =
			        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
			 
			    private static final Pattern PASSWORD_PATTERN =
			            Pattern.compile(PASSWORD_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			
			String user = request.getParameter("user");
			String password = request.getParameter("password"); //Stream@Java8
			String passwdConfirm = request.getParameter("passwdConfirm");
			String email = request.getParameter("email");
			
			if(user!=null && password !=null && PASSWORD_PATTERN.matcher(password).matches() &&
					passwdConfirm!=null && password.equals(passwdConfirm) && email!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("fecha", session.getCreationTime());
				session.setAttribute("registrado", true);	
				
				response.sendRedirect(request.getContextPath()+"/ReservarServlet");				
				return;
		}
		
		response.sendRedirect(request.getContextPath());
	}

}

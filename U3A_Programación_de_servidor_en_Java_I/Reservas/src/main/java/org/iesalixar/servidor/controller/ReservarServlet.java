package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReservarServlet
 */
@WebServlet("/ReservarServlet")
public class ReservarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("registrado")!=null && ((boolean)session.getAttribute("registrado"))
				&& session.getAttribute("user")!= null && session.getAttribute("fecha")!= null) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
			
			return;
		}
		session.invalidate();
		response.sendRedirect(request.getContextPath());
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("start")!=null && request.getParameter("end")!=null &&
				request.getParameter("personas")!=null && request.getParameter("servicios")!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("start", request.getParameter("start"));
			session.setAttribute("end", request.getParameter("end"));
			session.setAttribute("personas", request.getParameter("personas"));
			session.setAttribute("servicios", request.getParameterValues("servicios"));
			
			response.sendRedirect(request.getContextPath()+"/ConfirmarServlet");				
			return;
			
		}else {
			response.sendRedirect(request.getContextPath()+"/ReservarServlet");
			return;
		}
	}

}

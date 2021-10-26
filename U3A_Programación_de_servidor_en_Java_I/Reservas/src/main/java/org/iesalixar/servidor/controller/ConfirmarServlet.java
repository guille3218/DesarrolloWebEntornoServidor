package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;	
import org.iesalixar.servidor.model.Reserva;

/**
 * Servlet implementation class ConfirmarServlet
 */
@WebServlet("/ConfirmarServlet")
public class ConfirmarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("start")!=null && session.getAttribute("end")!=null &&
				session.getAttribute("personas")!=null && session.getAttribute("servicios")!=null) {
			Reserva reserva = new Reserva();
			
			reserva.setFechaInicio((String)session.getAttribute("start"));
			reserva.setFechaFin((String)session.getAttribute("end"));
			reserva.setPersonas(Integer.parseInt((String)session.getAttribute("personas")));
			reserva.setServicios((String[])session.getAttribute("servicios"));
			
			request.setAttribute("reservaBean", reserva);
			
			request.getRequestDispatcher("confirmar.jsp").forward(request, response);
			return;
		}else {
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		}
		
	}

}

package edu.m2i.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.entites.Admin;
import edu.m2i.service.AdminService;
import edu.m2i.service.AdminServiceImpl;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService;

    /**
     * Default constructor. 
     */
    public AuthentificationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String paramLogin = request.getParameter("login");
		final String paramMdp = request.getParameter("mdp");
		
		adminService = new AdminServiceImpl();
		if (adminService.authentifier(new Admin(paramLogin, paramMdp))) {
			response.sendRedirect("client.jsp");
//			request.getRequestDispatcher("/client.jsp").forward(request, response);
		} else {
			String messageErreur = "Login/Mdp erroné(s)";
			request.setAttribute("erreurAuthentification", messageErreur);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
	}

}

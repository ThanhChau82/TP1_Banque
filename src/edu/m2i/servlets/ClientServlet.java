package edu.m2i.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.entites.Client;
import edu.m2i.service.ClientService;
import edu.m2i.service.ClientServiceImpl;
import edu.m2i.validators.ValidateBanque;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ValidateBanque validateBanque = new ValidateBanque();
	
	private ClientService clientService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNom = request.getParameter("nom");
		String paramPrenom = request.getParameter("prenom");
		String paramEmail = request.getParameter("email");
		String paramTel = request.getParameter("telephone");
		String paramAdresse = request.getParameter("adresse");
		String paramCode = request.getParameter("code");
		
		if (paramNom != null && !paramNom.isBlank() &&  
			paramPrenom != null && !paramPrenom.isBlank() && 
			paramTel!= null && !paramTel.isBlank() && 
			paramAdresse != null && !paramAdresse.isBlank() &&
			paramCode != null && !paramCode.isBlank()) {
			
			int codeAppli = validateBanque.convertirInteger(paramCode);
			Client client = new Client(paramNom, paramPrenom, paramEmail, paramAdresse, paramTel, codeAppli, 0);
			clientService = new ClientServiceImpl();
			clientService.saveClient(client);
			
			request.getRequestDispatcher("/action.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

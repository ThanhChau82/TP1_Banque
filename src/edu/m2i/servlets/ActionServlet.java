package edu.m2i.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.entites.Action;
import edu.m2i.entites.Client;
import edu.m2i.service.ActionService;
import edu.m2i.service.ActionServiceImpl;
import edu.m2i.service.ClientService;
import edu.m2i.service.ClientServiceImpl;
import edu.m2i.validators.ValidateBanque;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ActionService actionService;
	private ClientService clientService;
	private ValidateBanque validateBanque;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les paramètres
		String paramMontant = request.getParameter("montant");
		String paramType = request.getParameter("type");
		
		// Si les params OK
		String messageErreurAction = "";
		if (paramMontant != null && !paramMontant.isBlank()
			&& paramType != null && !paramType.isBlank()) {			
			
			try {
				// Convertir montant en double.
				validateBanque = new ValidateBanque();
				double montant = validateBanque.convertirDouble(paramMontant);
				
				// Récupérer le client via son id.
//				clientService = new ClientServiceImpl();
//				Client client = clientService.findByIdBdd(1); // A voir pour récupérer idClient via la session.
				Client client = new Client();
				client.setId(1);
				client.setSolde(3000.0);
				
				// Créer une action pour le client.				
				Action action = new Action(montant, paramType, client.getId()); 
				
				// Ajouter une action pour ce client.s
				actionService = new ActionServiceImpl();
				if (actionService.saveAction(action, client)) {
					response.sendRedirect("listeActions.jsp");
//					request.getRequestDispatcher("/listeActions.jsp").forward(request, response);
				} else {
					messageErreurAction = "Echec d'ajout de l'action";
					request.setAttribute("erreurSaveAction", messageErreurAction);
					request.getRequestDispatcher("/action.jsp").forward(request, response);
				}
			} catch (Exception e) {
				messageErreurAction = "Montant n'est pas convertible !";
				request.setAttribute("erreurSaveAction", messageErreurAction);
				request.getRequestDispatcher("/action.jsp").forward(request, response);
			}					
		} else {
			messageErreurAction = "Paramètre(s) null(s) ou blank(s)";
			request.setAttribute("erreurSaveAction", messageErreurAction);
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

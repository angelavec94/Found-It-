package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

/**
 * Servlet implementation class GestioneModeratoreController
 */
@WebServlet("/GestioneModeratoreController")
public class GestioneModeratoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  UtenteModel modelUtente = new UtenteModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneModeratoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(request.getParameter("action").equals("bannare")){
			try {
				UtenteBean utente = modelUtente.doRetrieveByKey(request.getParameter("codiceFiscale"));
				utente.setTipo("bannato");
				modelUtente.doUpdate(utente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String redirectedPage = "/jsp/paginaModeratore.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		if(request.getParameter("action").equals("eliminare")){
			try {
				modelUtente.doDelete(request.getParameter("codiceFiscale"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String redirectedPage = "/jsp/paginaModeratore.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
		if(request.getParameter("action").equals("sbannare")){
			try {
				UtenteBean utente = modelUtente.doRetrieveByKey(request.getParameter("codiceFiscale"));
				if(utente.getSocietaSportiva_PartitaIva()!=null){
					utente.setTipo("partnerSportivo");
				}else{
					utente.setTipo("utenteSemplice");
				}
				modelUtente.doUpdate(utente);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String redirectedPage = "/jsp/paginaModeratore.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
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

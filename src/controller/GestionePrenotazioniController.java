package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CampoSportivoBean;

@WebServlet("/GestionePrenotazioniController")
public class GestionePrenotazioniController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public GestionePrenotazioniController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idCampo = Integer.parseInt(request.getParameter("idCampo"));
		request.setAttribute("idCampo", idCampo);
		request.getRequestDispatcher("/jsp/gestionePrenotazioni.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}

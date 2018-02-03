package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrenotazioneModel;
import model.PrenotazioneModelDM;

@WebServlet("/RimuoviPrenotazioneController")
public class RimuoviPrenotazioneController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static PrenotazioneModel model=new PrenotazioneModelDM();
	
	public RimuoviPrenotazioneController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idPrenotazione=Integer.parseInt(request.getParameter("idPrenotazione"));
		if(request.getParameter("action")!=null&&request.getParameter("action").equals("deleteByUtente")){
			try {
				model.doDelete(idPrenotazione);
				response.sendRedirect(request.getContextPath()+"/jsp/profiloUtente.jsp");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				int idCampo=Integer.parseInt(request.getParameter("idCampo"));
				model.doDelete(idPrenotazione);
				request.setAttribute("idCampo", idCampo);
				request.getRequestDispatcher("/jsp/gestionePrenotazioni.jsp").forward(request, response);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

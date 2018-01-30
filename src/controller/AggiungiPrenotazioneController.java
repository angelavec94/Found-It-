package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrenotazioneBean;
import model.PrenotazioneModel;
import model.PrenotazioneModelDM;

@WebServlet("/AggiungiPrenotazioneController")
public class AggiungiPrenotazioneController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	PrenotazioneModel model=new PrenotazioneModelDM();
	
	public AggiungiPrenotazioneController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idCampo=Integer.parseInt(request.getParameter("idCampo"));
		String cfPartner=request.getParameter("codiceFiscalePartner");
		String agg=request.getParameter("aggiungi");
		if(agg!=null&&agg.equals("no")){
			request.setAttribute("idCampo", idCampo);
			request.setAttribute("cfPartner", cfPartner);
			request.getRequestDispatcher("/jsp/aggiungiPrenotazione.jsp").forward(request, response);
		} else {
			PrenotazioneBean toAdd=new PrenotazioneBean();
			toAdd.setIdPrenotazione(Integer.parseInt(request.getParameter("idPrenotazione")));
			toAdd.setData(Date.valueOf(request.getParameter("data")));
			long oraInMs=(((Integer.parseInt(request.getParameter("orario"))-1)*60)*60)*1000;
			toAdd.setOra(new Time(oraInMs));
			toAdd.setSaldata(false);
			toAdd.setTipo("SulCampo");
			toAdd.setIdCampoSportivo(Integer.parseInt(request.getParameter("idCampo")));
			toAdd.setCodiceFiscaleUtente(request.getParameter("cfPartner"));
			try {
				model.doSave(toAdd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/jsp/gestioneCampi.jsp");
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

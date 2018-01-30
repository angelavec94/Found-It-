package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CampoSportivoBean;
import model.CampoSportivoModel;
import model.CampoSportivoModelDM;
import model.PrenotazioneBean;
import model.PrenotazioneModel;
import model.PrenotazioneModelDM;

@WebServlet("/ConfermaPrenotazioneController")
public class ConfermaPrenotazioneController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static PrenotazioneModel modelPr = new PrenotazioneModelDM();
	
    public ConfermaPrenotazioneController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Date data = Date.valueOf(request.getParameter("dataPrenotazione"));
		int or= Integer.parseInt(request.getParameter("oraPrenotazione"));
		long oraInMs=(((or-1)*60)*60)*1000;
		Time ora = new Time(oraInMs);
		boolean saldata;
		if(request.getParameter("saldata").equals("true"))
			saldata=true;
		else
			saldata=false;
		String tipo=request.getParameter("tipo");
		int idCampo=Integer.parseInt(request.getParameter("idCampo"));
		String cfUtente=request.getParameter("cfUtente");
		int idPrenotazione;
		
		try {
			Collection<PrenotazioneBean> prenotazioni=modelPr.doRetrieveAll("IDPRENOTAZIONE");
			if(prenotazioni!=null && prenotazioni.size()!=0){
				PrenotazioneBean[] prova=new PrenotazioneBean[prenotazioni.size()];
				prova=prenotazioni.toArray(prova);
				PrenotazioneBean ultimo=prova[prova.length-1];
				idPrenotazione=ultimo.getIdPrenotazione()+1;
				PrenotazioneBean toAdd=new PrenotazioneBean();
				toAdd.setIdPrenotazione(idPrenotazione);
				toAdd.setData(data);
				toAdd.setOra(ora);
				toAdd.setSaldata(saldata);
				toAdd.setTipo(tipo);
				toAdd.setIdCampoSportivo(idCampo);
				toAdd.setCodiceFiscaleUtente(cfUtente);
				modelPr.doSave(toAdd);
				request.getSession().removeAttribute("risultatiRicerca");
				request.getSession().removeAttribute("oraPrenotazione");
				request.getSession().removeAttribute("dataPrenotazione");
				response.sendRedirect(request.getContextPath()+"/jsp/home.jsp");
			}
			else{
				idPrenotazione=0;
				PrenotazioneBean toAdd=new PrenotazioneBean();
				toAdd.setIdPrenotazione(idPrenotazione);
				toAdd.setData(data);
				toAdd.setOra(ora);
				toAdd.setSaldata(saldata);
				toAdd.setTipo(tipo);
				toAdd.setIdCampoSportivo(idCampo);
				toAdd.setCodiceFiscaleUtente(cfUtente);
				modelPr.doSave(toAdd);
				request.getSession().removeAttribute("risultatiRicerca");
				request.getSession().removeAttribute("oraPrenotazione");
				request.getSession().removeAttribute("dataPrenotazione");
				response.sendRedirect(request.getContextPath()+"/jsp/home.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

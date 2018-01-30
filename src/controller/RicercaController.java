package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

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

@WebServlet("/RicercaController")
public class RicercaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel modelCampo = new CampoSportivoModelDM();
	static PrenotazioneModel modelPre = new PrenotazioneModelDM();
	
    public RicercaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String tipo = request.getParameter("tipo");
		String luogo = request.getParameter("luogo");
		String data = request.getParameter("data");
		int ora=0;
		if(!request.getParameter("ora").equals("")){
			ora = Integer.parseInt(request.getParameter("ora"));
		}
		
		Collection<CampoSportivoBean> risultatiRicerca = new LinkedList<CampoSportivoBean>();
		
		try {
			Collection<CampoSportivoBean> campi = modelCampo.doRetrieveByLuogoTipo(luogo, tipo);
				if (campi != null && campi.size() != 0) {
					Iterator<CampoSportivoBean> it = campi.iterator();
					while (it.hasNext()) {
						CampoSportivoBean campo = (CampoSportivoBean) it.next();
						String[] fascia=campo.getFasciaOraria().split("-");
						int oraInizio=Integer.parseInt(fascia[0]);
						int oraFine=Integer.parseInt(fascia[1]);
						
						Collection<PrenotazioneBean> prenotazioni=modelPre.doRetrieveByIDCampo(campo.getIdCampoSportivo());
						
						if(ora>=oraInizio && ora <=oraFine){
							if(prenotazioni == null || prenotazioni.size()==0){
								risultatiRicerca.add(campo);
							}
							else{
								Iterator<PrenotazioneBean> ite=prenotazioni.iterator();
								boolean ok=true;
								while(ite.hasNext()){
									PrenotazioneBean pr=(PrenotazioneBean)ite.next();
									long oraInMs=(((ora-1)*60)*60)*1000;
									if(pr.getData().compareTo(Date.valueOf(data))==0 && pr.getOra().getTime()==oraInMs){
										ok=false;
									}
								}
								if(ok){
									risultatiRicerca.add(campo);
								}
							}
							
						}
					}
					request.getSession().setAttribute("risultatiRicerca", risultatiRicerca);
					request.getSession().setAttribute("oraPrenotazione", ora);
					request.getSession().setAttribute("dataPrenotazione", data);
					response.sendRedirect(request.getContextPath()+"/jsp/risultatiRicerca.jsp");
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

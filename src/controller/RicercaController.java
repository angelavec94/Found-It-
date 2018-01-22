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
		PrintWriter out = response.getWriter();
		String tipo = request.getParameter("tipo");
		String luogo = request.getParameter("luogo");
		String data = request.getParameter("data");
		int ora = Integer.parseInt(request.getParameter("ora"));
		int minuti = Integer.parseInt(request.getParameter("minuti"));
		String lat = request.getParameter("latitude");
		String lng = request.getParameter("longitude");
		
		Collection<CampoSportivoBean> risultatiRicerca = new LinkedList<CampoSportivoBean>();

		System.out.println("I parametri passati sono: tipo="+tipo+",luogo="+luogo+",data="+data+",ora="+ora+",minuti="+minuti+"latitudine="+lat+",longitudine="+lng);
		
		try {
			Collection<?> campi = modelCampo.doRetrieveAll("tipologia");
				if (campi != null && campi.size() != 0) {
					Iterator<?> it = campi.iterator();
					while (it.hasNext()) {
						CampoSportivoBean campo = (CampoSportivoBean) it.next();
						String[] fascia=campo.getFasciaOraria().split("-");
						int oraInizio=Integer.parseInt(fascia[0]);
						System.out.println(oraInizio);
						int oraFine=Integer.parseInt(fascia[1]);
						
						Collection<PrenotazioneBean> prenotazioni=modelPre.doRetrieveAll("");
						
						if(campo.getTipologia().equals(tipo) && ora>=oraInizio && ora <=oraFine && campo.getLuogo().equals(luogo)){
							if(prenotazioni == null || prenotazioni.size()==0){
								risultatiRicerca.add(campo);
							}
							else{
								Iterator<PrenotazioneBean> ite=prenotazioni.iterator();
								boolean ok=true;
								while(ite.hasNext()){
									PrenotazioneBean pr=(PrenotazioneBean)ite.next();
									long oraInMs=(((ora-1)*60)*60)*1000;
									if(pr.getIdCampoSportivo()==campo.getIdCampoSportivo() && pr.getData().compareTo(Date.valueOf(data))==0 && pr.getOra().getTime()==oraInMs){
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

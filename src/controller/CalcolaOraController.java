package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet("/CalcolaOraController")
public class CalcolaOraController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	PrenotazioneModel model=new PrenotazioneModelDM();
	CampoSportivoModel modelC=new CampoSportivoModelDM();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date data=Date.valueOf(req.getParameter("data"));
		int idCampo=Integer.parseInt(req.getParameter("idCampo"));
		String cfPartner=req.getParameter("cfPartner");
		int idPrenotazione;
		try {
			CampoSportivoBean campo=modelC.doRetrieveByKey(idCampo);
			String[] orari=campo.getFasciaOraria().split("-");
			int start=Integer.parseInt(orari[0]);
			int end=Integer.parseInt(orari[1])+1;
			ArrayList<String> toReturn=new ArrayList<String>();
			Collection<PrenotazioneBean> prenotazioni=model.doRetrieveByIDCampo(idCampo);
			Collection<PrenotazioneBean> allPrenotazioni=model.doRetrieveAll("IDPRENOTAZIONE");
			if(allPrenotazioni!=null&&allPrenotazioni.size()!=0){
				PrenotazioneBean[] prova=new PrenotazioneBean[allPrenotazioni.size()];
				prova=allPrenotazioni.toArray(prova);
				PrenotazioneBean ultimo=prova[prova.length-1];
				idPrenotazione=ultimo.getIdPrenotazione()+1;
			} else {
				idPrenotazione=0;
			}
			if(prenotazioni==null||prenotazioni.size()==0){
				for(int i=start;i<end;i++){
					toReturn.add(""+i);
				}
				req.setAttribute("risultati", toReturn);
				req.setAttribute("idCampo", idCampo);
				req.setAttribute("idPrenotazione", idPrenotazione);
				req.setAttribute("cfPartner", cfPartner);
				req.setAttribute("data", data);
				req.setAttribute("calcola", "si");
				req.getRequestDispatcher("/jsp/aggiungiPrenotazione.jsp").forward(req, resp);
			} else {
				for(int i=start;i<end;i++){
					toReturn.add(""+i);
				}
				Iterator<PrenotazioneBean> it=prenotazioni.iterator();
				while(it.hasNext()){
					PrenotazioneBean bean=it.next();
					if(bean.getData().compareTo(data)==0){
					String toCheck=(bean.getOra().toString().split(":"))[0];
					if(Integer.parseInt(toCheck)<10){
						toCheck=toCheck.substring(1);
					}
					ArrayList<String> checkArray=(ArrayList<String>)toReturn.clone();
						for(String s:checkArray){
							if(s.equals(toCheck)){
								toReturn.remove(s);
							}
						}
					}
				}
				req.setAttribute("risultati", toReturn);
				req.setAttribute("idCampo", idCampo);
				req.setAttribute("idPrenotazione", idPrenotazione);
				req.setAttribute("cfPartner", cfPartner);
				req.setAttribute("data", data);
				req.setAttribute("calcola", "si");
				req.getRequestDispatcher("/jsp/aggiungiPrenotazione.jsp").forward(req, resp);	
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

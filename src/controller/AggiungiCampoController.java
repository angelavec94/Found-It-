package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CampoSportivoBean;
import model.CampoSportivoModel;
import model.CampoSportivoModelDM;

@WebServlet("/AggiungiCampoController")
public class AggiungiCampoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel model=new CampoSportivoModelDM();
	
	public AggiungiCampoController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idCampoSportivo;
		String nome=request.getParameter("nomeCampo");
		String fascia=request.getParameter("fasciaOraria");
		String luogo=request.getParameter("luogo");
		String tipologia=request.getParameter("tipo");
		Double prezzoOnline=Double.parseDouble(request.getParameter("prezzoOnline"));
		Double prezzoSulCampo=Double.parseDouble(request.getParameter("prezzoSulCampo"));
		String partitaIVA=request.getParameter("partitaIva");
		
		try {
			Collection<CampoSportivoBean> campi=model.doRetrieveAll("");
			if(campi!=null && campi.size()!=0){
				CampoSportivoBean[] campiArray=new CampoSportivoBean[campi.size()];
				campiArray=campi.toArray(campiArray);
				CampoSportivoBean ultimo=campiArray[campiArray.length-1];
				idCampoSportivo=ultimo.getIdCampoSportivo()+1;
				CampoSportivoBean toAdd=new CampoSportivoBean();
				toAdd.setIdCampoSportivo(idCampoSportivo);
				toAdd.setNome(nome);
				toAdd.setFasciaOraria(fascia);
				toAdd.setLuogo(luogo);
				toAdd.setTipologia(tipologia);
				toAdd.setPrezzoOnline(prezzoOnline);
				toAdd.setPrezzoSulCampo(prezzoSulCampo);
				toAdd.setPartitaIvaSocieta(partitaIVA);
				model.doSave(toAdd);
				response.sendRedirect(request.getContextPath()+"/jsp/gestioneCampi.jsp");
			}
			else{
				idCampoSportivo=0;
				CampoSportivoBean toAdd=new CampoSportivoBean();
				toAdd.setIdCampoSportivo(idCampoSportivo);
				toAdd.setNome(nome);
				toAdd.setFasciaOraria(fascia);
				toAdd.setLuogo(luogo);
				toAdd.setTipologia(tipologia);
				toAdd.setPrezzoOnline(prezzoOnline);
				toAdd.setPrezzoSulCampo(prezzoSulCampo);
				toAdd.setPartitaIvaSocieta(partitaIVA);
				model.doSave(toAdd);
				response.sendRedirect(request.getContextPath()+"/jsp/gestioneCampi.jsp");
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

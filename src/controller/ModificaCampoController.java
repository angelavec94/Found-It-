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

@WebServlet("/ModificaCampoController")
public class ModificaCampoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel model=new CampoSportivoModelDM();
	
	public ModificaCampoController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idCampoSportivo=Integer.parseInt(request.getParameter("idCampo"));
		String modifica=request.getParameter("modifica");
		if(modifica!=null&&modifica.equals("no")){
			request.setAttribute("idCampo", idCampoSportivo);
			request.getRequestDispatcher("/jsp/modificaCampo.jsp").forward(request, response);
		}
		else{
			try {
			CampoSportivoBean toUpdate=new CampoSportivoBean();
			String nome=request.getParameter("nomeCampo");
			String fascia=request.getParameter("fasciaOraria");
			String luogo=request.getParameter("luogo");
			String tipologia=request.getParameter("tipo");
			Double prezzoOnline=Double.parseDouble(request.getParameter("prezzoOnline"));
			Double prezzoSulCampo=Double.parseDouble(request.getParameter("prezzoSulCampo"));
			String partitaIVA=request.getParameter("partitaIva");
			toUpdate.setIdCampoSportivo(idCampoSportivo);
			toUpdate.setNome(nome);
			toUpdate.setFasciaOraria(fascia);
			toUpdate.setLuogo(luogo);
			toUpdate.setTipologia(tipologia);
			toUpdate.setPrezzoOnline(prezzoOnline);
			toUpdate.setPrezzoSulCampo(prezzoSulCampo);
			toUpdate.setPartitaIvaSocieta(partitaIVA);
			model.doUpdate(toUpdate);
			response.sendRedirect(request.getContextPath()+"/jsp/gestioneCampi.jsp");
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

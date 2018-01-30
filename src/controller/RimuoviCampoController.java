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

@WebServlet("/RimuoviCampoController")
public class RimuoviCampoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel model=new CampoSportivoModelDM();
	
	public RimuoviCampoController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idCampoSportivo=Integer.parseInt(request.getParameter("idCampo"));
		
		try {
			model.doDelete(idCampoSportivo);
			response.sendRedirect(request.getContextPath()+"/jsp/gestioneCampi.jsp");
			
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

package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/PrenotazioneCampoController")
public class PrenotazioneCampoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel model = new CampoSportivoModelDM();
	
    public PrenotazioneCampoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int idCampo = Integer.parseInt(request.getParameter("idCampo"));
		
		CampoSportivoBean campo = new CampoSportivoBean();
		
		try {
			campo = model.doRetrieveByKey(idCampo);
				if (campo != null) {
					request.getSession().setAttribute("campoDaPrenotare", campo);
					response.sendRedirect(request.getContextPath()+"/jsp/prenotazioneCampo.jsp");
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

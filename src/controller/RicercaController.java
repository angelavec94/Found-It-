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

@WebServlet("/RicercaController")
public class RicercaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CampoSportivoModel model = new CampoSportivoModelDM();
	
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
			Collection<?> campi = model.doRetrieveAll("tipologia");
				if (campi != null && campi.size() != 0) {
					Iterator<?> it = campi.iterator();
					while (it.hasNext()) {
						CampoSportivoBean campo = (CampoSportivoBean) it.next();
						int oraInizio=Integer.parseInt(new Integer(campo.getFasciaOraria()).toString().substring(0, 2));
						int oraFine=Integer.parseInt(new Integer(campo.getFasciaOraria()).toString().substring(2));
						if(campo.getTipologia().equals(tipo) && ora>=oraInizio && ora <=oraFine ){
							risultatiRicerca.add(campo);
						}
					}
					request.getSession().setAttribute("risultatiRicerca", risultatiRicerca);
					request.getSession().setAttribute("oraPrenotazione", ora);
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

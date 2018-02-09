package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SocietaSportivaBean;
import model.SocietaSportivaModel;
import model.SocietaSportivaModelDM;
import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

/**
 * Servlet implementation class SocietaController
 */
@WebServlet("/SocietaController")
public class SocietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  UtenteModel modelUtente = new UtenteModelDM();
	static  SocietaSportivaModel modelSocieta = new SocietaSportivaModelDM();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String codiceFiscale= request.getParameter("CodiceFiscaleUtente");
		 UtenteBean utente = new UtenteBean();
		 
		 try {
			utente= modelUtente.doRetrieveByKey(codiceFiscale);
		 }catch (SQLException e) {
			e.printStackTrace();
		  }
			 SocietaSportivaBean societa = new SocietaSportivaBean();
			
			// Copio tutti i parametri di input nelle variabili locali
			String nomeSocieta= request.getParameter("nomeSocieta");
			String indirizzoSede= request.getParameter("indirizzoSede");
			String partitaIva= request.getParameter("partitaIva");
			String telefonoSocieta= request.getParameter("telefono");
			String codiceAutenticazione= request.getParameter("codiceAutenticazione");
			
			SocietaSportivaBean societaDb= new SocietaSportivaBean();
			try {
				societaDb = modelSocieta.doRetrieveByKey(partitaIva);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			

			
			societa.setNomeSocieta(nomeSocieta);
			societa.setIndirizzoSede(indirizzoSede);
			societa.setPartitaIva(partitaIva);
			societa.setTelefono(telefonoSocieta);
			societa.setCodiceAutenticazione(codiceAutenticazione);
			
				try {
					if(societaDb==null){
						modelSocieta.doSave(societa);
						utente= (UtenteBean) request.getSession().getAttribute("utenteSalvato");
						utente.setSocietaSportiva_PartitaIva(partitaIva);
						modelUtente.doUpdate(utente);
						String message = "Società Sportiva Registrata!";
						request.getSession().setAttribute("message", message);
						response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
			
					}else if(societa.getPartitaIva().equals(societaDb.getPartitaIva())){	
						String message = "Partita Iva già presente nel database!";
						request.getSession().setAttribute("message", message);	
						String redirectedPage = "/jsp/registrazioneSocieta.jsp";
						response.sendRedirect(request.getContextPath() + redirectedPage);
				
					}
					else{
						modelSocieta.doSave(societa);
						utente= (UtenteBean) request.getSession().getAttribute("utenteSalvato");
						utente.setSocietaSportiva_PartitaIva(partitaIva);
						modelUtente.doUpdate(utente);
						String message = "Società Sportiva Registrata!";
						request.getSession().setAttribute("message", message);
						response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
			
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
		}

}

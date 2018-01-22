package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SocietaSportivaBean;
import model.SocietaSportivaModel;
import model.SocietaSportivaModelDM;
import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;
import util.ValidationUtil;

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
			
			if( ValidationUtil.isEmpty(nomeSocieta) || !ValidationUtil.isAValidString(nomeSocieta,ValidationUtil.REGEX_NOME_SOCIETA)){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Errore: nome Società non inserito oppure non valido!');");
			    out.println("location='"+request.getContextPath()+"/jsp/registrazioneSocieta.jsp';");
			    out.println("</script>");
			}
			 if( ValidationUtil.isEmpty(indirizzoSede) || !ValidationUtil.isAValidString(indirizzoSede,ValidationUtil.REGEX_INDIRIZZO_SEDE)){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Errore: indirizzo sede non inserito oppure non valido!');");
			    out.println("location='"+request.getContextPath()+"/jsp/registrazioneSocieta.jsp';");
			    out.println("</script>");
			}
			if( ValidationUtil.isEmpty(partitaIva) || !ValidationUtil.isAValidString(partitaIva,ValidationUtil.REGEX_PARTITA_IVA)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: partita iva non inserita oppure non valida!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneSocieta.jsp';");
				    out.println("</script>");
				}
			 if( ValidationUtil.isEmpty(telefonoSocieta) || !ValidationUtil.isAValidString(telefonoSocieta,ValidationUtil.REGEX_TELEFONO)){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Errore: telefono non inserito oppure non valido!');");
			    out.println("location='"+request.getContextPath()+"/jsp/registrazioneSocieta.jsp';");
			    out.println("</script>");
			}
			 if( ValidationUtil.isEmpty(codiceAutenticazione) || !ValidationUtil.isAValidString(codiceAutenticazione,ValidationUtil.REGEX_CODICE_AUTENTICAZIONE)){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Errore: Codice di Autenticazione non inserito oppure non valido!');");
			    out.println("location='"+request.getContextPath()+"/jsp/registrazioneSocieta.jsp';");
			    out.println("</script>");
			}
			
			
			
			utente.setSocietaSportiva_PartitaIva(partitaIva);
			
			societa.setNomeSocieta(nomeSocieta);
			societa.setIndirizzoSede(indirizzoSede);
			societa.setPartitaIva(partitaIva);
			societa.setTelefono(telefonoSocieta);
			societa.setCodiceAutenticazione(codiceAutenticazione);
			
				try {
					modelSocieta.doSave(societa);
					modelUtente.doUpdate(utente);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
	
		}

}

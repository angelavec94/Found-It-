package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;
import model.SocietaSportivaModelDM;
import model.SocietaSportivaModel;
import model.SocietaSportivaBean;
import util.ValidationUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  UtenteModel modelUtente = new UtenteModelDM();
	static  SocietaSportivaModel modelSocieta = new SocietaSportivaModelDM();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		UtenteBean utente = new UtenteBean();
		
		// Copio tutti i parametri di input nelle variabili locali
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String codicefiscale= request.getParameter("codicefiscale");
				String citta = request.getParameter("citta");
				String provincia = request.getParameter("activityProvince");
				String cap = request.getParameter("cap");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confpassword= request.getParameter("confpassword");
				String possiediSocietaSportiva = request.getParameter("possiedisocietasportiva");
				
				if( ValidationUtil.isEmpty(nome) || !ValidationUtil.isAValidString(nome,ValidationUtil.REGEX_NOME)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: nome non inserito oppure non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(cognome) || !ValidationUtil.isAValidString(cognome,ValidationUtil.REGEX_GENERALE)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: cognome non inserito oppure non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(codicefiscale) || !ValidationUtil.isAValidString(codicefiscale,ValidationUtil.REGEX_CODICE_FISCALE)){
						out.println("<script type=\"text/javascript\">");
					    out.println("alert('Errore: codice fiscale non inserita oppure non valida!');");
					    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
					    out.println("</script>");
					}
				 if( ValidationUtil.isEmpty(citta) || !ValidationUtil.isAValidString(citta,ValidationUtil.REGEX_GENERALE)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: citta' non inserita oppure non valida!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(provincia) || !ValidationUtil.isAValidString(provincia,ValidationUtil.REGEX_GENERALE)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: provincia non inserita oppure non valida!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(cap) || !ValidationUtil.isAValidString(cap,ValidationUtil.REGEX_CAP)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: cap non inserito oppure non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(telefono) || !ValidationUtil.isAValidString(telefono,ValidationUtil.REGEX_TELEFONO)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: telefono non inserito oppure non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(email) || !ValidationUtil.isAValidString(email,ValidationUtil.REGEX_EMAIL)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: email non inserita oppure non valida!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(username) || !ValidationUtil.isAValidString(username,ValidationUtil.REGEX_USERNAME)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: username non inserito oppure non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if( ValidationUtil.isEmpty(password) || !ValidationUtil.isAValidString(password,ValidationUtil.REGEX_PASSWORD)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: password non inserita oppure non valida!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if(!confpassword.equals(password)){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: I campi password e conferma password devono corrispondere!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				 if(possiediSocietaSportiva == null){
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: Devi dichiarare se possiedi o meno un campo sportivo!');");
				    out.println("location='"+request.getContextPath()+"/jsp/registrazioneUtente.jsp';");
				    out.println("</script>");
				}
				
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setCodiceFiscale(codicefiscale);
				utente.setCitta(citta);
				utente.setProvincia(provincia);
				utente.setCap(Integer.parseInt(cap));
				utente.setTelefono(telefono);
				utente.setEmail(email);
				utente.setUsername(username);
				String cryptedPassword = toSHA1(password.getBytes());
				utente.setPassword(cryptedPassword);
				
				
				if(possiediSocietaSportiva.equals("no")){
					utente.setTipo("utenteSemplice");		
					try{
						
						modelUtente.doSave(utente);
						
					} 
					catch(Exception e) 
					{
						e.printStackTrace();
					}
						
					String redirectedPage = "/jsp/home.jsp";
					response.sendRedirect(request.getContextPath() + redirectedPage);
			
				}
				else if(possiediSocietaSportiva.equals("si")){
					utente.setTipo("partnerSportivo");
					try {
						modelUtente.doSave(utente);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					 request.setAttribute("CodiceFiscaleUtente", utente.getCodiceFiscale());
					 request.getRequestDispatcher("/jsp/registrazioneSocieta.jsp").forward(request, response);
					 //RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/jsp/registrazioneSocieta.jsp");	
					//dispatcher.forward(request, response);
					/*Secondo andrea � tutto inutile
					 * SocietaSportivaBean societa = new SocietaSportivaBean();
					
					// Copio tutti i parametri di input nelle variabili locali
					String nomeSocieta= request.getParameter("nomeSocieta");
					String indirizzoSede= request.getParameter("indirizzoSede");
					String partitaIva= request.getParameter("partitaIva");
					String telefonoSocieta= request.getParameter("telefono");
					String codiceAutenticazione= request.getParameter("codiceAutenticazione");
					utente.setSocietaSportiva_PartitaIva(partitaIva);
					
					societa.setNomeSocieta(nomeSocieta);
					try {
						modelUtente.doSave(utente);
						modelSocieta.doSave(societa);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
				
					
			}
			
	
	
	
	
	
	
	
			/**
			 * Encrypt data into String type
			 * @param convertme array of bytes to be encrypt
			 * @return encrypted bytes
			 */
			public static String toSHA1(byte[] convertme) {
				MessageDigest md = null;
				try {
					md = MessageDigest.getInstance("SHA-1");
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				return new String(md.digest(convertme));
			}


}
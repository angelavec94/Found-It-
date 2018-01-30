package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;
import model.SocietaSportivaBean;
import model.SocietaSportivaModelDM;
import model.SocietaSportivaModel;
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
		SocietaSportivaBean societa= new SocietaSportivaBean();
		String action = request.getParameter("action");
		// INSERT
		if (action.equalsIgnoreCase("insert")) {
			action="";
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
					String message = "Registrazione effettuata con successo!";
					request.getSession().setAttribute("message", message);	
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
					
				}
		     }

		
					// LOGIN
					if (action.equalsIgnoreCase("login")) {
						action="";
						String username= request.getParameter("username");
						String password= request.getParameter("password");
						String cryptedPassword = toSHA1(password.getBytes());
						String redirectedPage;
					
						try {
							utente= modelUtente.doRetrieveByUsername(username);
							redirectedPage= "/jsp/home.jsp";
							
							if(utente == null || utente.getUsername() == null ){
								String message = "Username errato oppure inesistente!";
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath() + redirectedPage);
							}
							else if(utente.getPassword().equals(cryptedPassword)){
								HttpSession session = request.getSession(true);
								session.setAttribute("login",utente);
								session.setAttribute("utenteLoggato", true);
								String message = "Ehy "+utente.getUsername()+", Benvenuto in Found It!";
								request.getSession().setAttribute("message", message);
								System.out.println(utente);
								if(utente.getSocietaSportiva_PartitaIva()!=null && !(utente.getSocietaSportiva_PartitaIva().equals(""))){
									societa= modelSocieta.doRetrieveByKey(utente.getSocietaSportiva_PartitaIva());
									session.setAttribute("societa", societa);
								}
								if(utente.getTipo().equals("moderatore")){
									request.getSession().setAttribute("moderatorRoles", new Boolean(true));
									redirectedPage = "/jsp/paginaModeratore.jsp";
									response.sendRedirect(request.getContextPath() + redirectedPage);
									}
								else if(utente.getTipo().equals("bannato")){
									message="Utente bannato! Contattare l'amministratore";
									request.getSession().setAttribute("message", message);
									redirectedPage = "/jsp/home.jsp";
									response.sendRedirect(request.getContextPath() + redirectedPage);	
									session.invalidate();
								}
								else{
									response.sendRedirect(request.getContextPath() + redirectedPage);
								}

							}
							else{
								String message = "Password errata!";
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath() + redirectedPage);

							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					
					
					// LOGOUT
					if (action.equalsIgnoreCase("logout")) {
						action=""; 
							HttpSession session=request.getSession();  
							String redirectedPage = "/jsp/home.jsp";
							request.setAttribute("message", "Logout effettuato con successo!");
							response.sendRedirect(request.getContextPath() + redirectedPage);	
							session.invalidate();
							 
					}
					
					
					// MODIFICA TAB DATI PERSONALI IN PROFILO UTENTE
					if (action.equalsIgnoreCase("datiPersonali")) {
						action="";
						HttpSession session = request.getSession();
						UtenteBean utenteSessione= (UtenteBean) session.getAttribute("login");
						
						// Copio tutti i parametri di input nelle variabili locali
						String nome = request.getParameter("nome");
						String cognome = request.getParameter("cognome");
						String codicefiscale= request.getParameter("codicefiscale");
						String citta = request.getParameter("citta");
						String provincia = request.getParameter("activityProvince");
						String cap = request.getParameter("cap");
						String telefono = request.getParameter("telefono");

						if( ValidationUtil.isEmpty(nome) || !ValidationUtil.isAValidString(nome,ValidationUtil.REGEX_NOME)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: nome non inserito oppure non valido!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if( ValidationUtil.isEmpty(cognome) || !ValidationUtil.isAValidString(cognome,ValidationUtil.REGEX_GENERALE)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: cognome non inserito oppure non valido!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if( ValidationUtil.isEmpty(codicefiscale) || !ValidationUtil.isAValidString(codicefiscale,ValidationUtil.REGEX_CODICE_FISCALE)){
								out.println("<script type=\"text/javascript\">");
							    out.println("alert('Errore: codice fiscale non inserita oppure non valida!');");
							    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
							    out.println("</script>");
							}
						 if( ValidationUtil.isEmpty(citta) || !ValidationUtil.isAValidString(citta,ValidationUtil.REGEX_GENERALE)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: citta' non inserita oppure non valida!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if( ValidationUtil.isEmpty(provincia) || !ValidationUtil.isAValidString(provincia,ValidationUtil.REGEX_GENERALE)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: provincia non inserita oppure non valida!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if( ValidationUtil.isEmpty(cap) || !ValidationUtil.isAValidString(cap,ValidationUtil.REGEX_CAP)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: cap non inserito oppure non valido!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if( ValidationUtil.isEmpty(telefono) || !ValidationUtil.isAValidString(telefono,ValidationUtil.REGEX_TELEFONO)){
							out.println("<script type=\"text/javascript\">");
						    out.println("alert('Errore: telefono non inserito oppure non valido!');");
						    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
						    out.println("</script>");
						}
						 if(utente!=null){
							 utente.setNome(nome);
							 utente.setCognome(cognome);
							 utente.setCodiceFiscale(codicefiscale);
							 utente.setCitta(citta);
							 utente.setProvincia(provincia);
							 utente.setCap(Integer.parseInt(cap));
							 utente.setTelefono(telefono);
							 utente.setUsername(utenteSessione.getUsername());
							 utente.setPassword(utenteSessione.getPassword());
							 utente.setEmail(utenteSessione.getEmail());
							 utente.setTipo(utenteSessione.getTipo());
						 }
						 if(!(utente.equals(utenteSessione))){
							 try {
								 modelUtente.doUpdate(utente);
							 } catch (SQLException e) {
								 e.printStackTrace();
							 }
							 utenteSessione.setNome(nome);
							 utenteSessione.setCognome(cognome);
							 utenteSessione.setCodiceFiscale(codicefiscale);
							 utenteSessione.setCitta(citta);
							 utenteSessione.setProvincia(provincia);
							 utenteSessione.setCap(Integer.parseInt(cap));
							 utenteSessione.setTelefono(telefono);
							 
						 }
						 String message = "Dati Personali Modificati!";
							request.getSession().setAttribute("message", message);
						 String redirectedPage = "/jsp/profiloUtente.jsp";
						 response.sendRedirect(request.getContextPath() + redirectedPage);
						
					}
						
						// MODIFICA TAB DATI ACCOUNT IN PROFILO UTENTE
						if (action.equalsIgnoreCase("datiAccount")) {
							action="";
							HttpSession session = request.getSession();
							UtenteBean utenteSessione= (UtenteBean) session.getAttribute("login");
							
							// Copio tutti i parametri di input nelle variabili locali
							String username = request.getParameter("username");
							String password = request.getParameter("password");
							String confpassword = request.getParameter("confpassword");
							String email = request.getParameter("email");
							
							
							 if( ValidationUtil.isEmpty(password) || !ValidationUtil.isAValidString(password,ValidationUtil.REGEX_PASSWORD)){
								out.println("<script type=\"text/javascript\">");
							    out.println("alert('Errore: password non inserita oppure non valida!\n NB:La password deve contenere almeno 1 carattere maiuscolo,1minuscolo e 1 numero e deve essere lunga almeno 8');");
							    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
							    out.println("</script>");
							}
							 if(!confpassword.equals(password)){
								out.println("<script type=\"text/javascript\">");
							    out.println("alert('Errore: I campi password e conferma password devono corrispondere!');");
							    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
							    out.println("</script>");
							}
							 if( ValidationUtil.isEmpty(email) || !ValidationUtil.isAValidString(email,ValidationUtil.REGEX_EMAIL)){
									out.println("<script type=\"text/javascript\">");
								    out.println("alert('Errore: email non inserita oppure non valida!');");
								    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
								    out.println("</script>");
							}
							
							 
							 if(utente!=null){
								 utente.setUsername(username);
								 utente.setPassword(toSHA1(password.getBytes()));
								 utente.setEmail(email);
								 utente.setNome(utenteSessione.getNome());
								 utente.setCognome(utenteSessione.getCognome());
								 utente.setCodiceFiscale(utenteSessione.getCodiceFiscale());
								 utente.setCitta(utenteSessione.getCitta());
								 utente.setProvincia(utenteSessione.getProvincia());
								 utente.setCap(utenteSessione.getCap());
								 utente.setTelefono(utenteSessione.getTelefono());
								 utente.setTipo(utenteSessione.getTipo());

							 }
							 if(!(utente.equals(utenteSessione))){
								 try {
									 modelUtente.doUpdate(utente);
								 } catch (SQLException e) {
									 e.printStackTrace();
								 }
								 utenteSessione.setUsername(username);
								 utenteSessione.setPassword(password);
								 utenteSessione.setEmail(email);			 
							 }
							 String message = "Dati Account Modificati!";
								request.getSession().setAttribute("message", message);
							 String redirectedPage = "/jsp/profiloUtente.jsp";
							 response.sendRedirect(request.getContextPath() + redirectedPage);
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

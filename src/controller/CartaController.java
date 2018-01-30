package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartaBean;
import model.CartaModel;
import model.CartaModelDM;
import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

@WebServlet("/CartaController")
public class CartaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static CartaModel model = new CartaModelDM();
	
    public CartaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String numero = request.getParameter("numeroCarta");
		String intestatario = request.getParameter("intestatarioCarta");
		Date data = Date.valueOf(request.getParameter("scadenzaCarta"));
		int cod = Integer.parseInt(request.getParameter("cvvCarta"));
		String cfUtente = request.getParameter("cfUtente");
		CartaBean carta = new CartaBean();
		carta.setIntestatario(intestatario);
		carta.setNumeroCarta(numero);
		carta.setScadenza(data);
		carta.setCvv(cod);
		
		try {
			CartaModel car=new CartaModelDM();
			car.doSave(carta);
			UtenteModel ut=new UtenteModelDM();
			UtenteBean toUpdate=ut.doRetrieveByKey(cfUtente);
			toUpdate.setNumeroCarta(numero);
			ut.doUpdate(toUpdate);
			request.getSession().setAttribute("login", toUpdate);
			response.sendRedirect(request.getContextPath()+"/jsp/prenotazioneCampo.jsp");
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

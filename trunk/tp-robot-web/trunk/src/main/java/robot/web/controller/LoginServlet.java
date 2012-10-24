package robot.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import robots.appModel.JugadorInicio;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	JugadorInicio inicio = new JugadorInicio();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String username = req.getParameter("user_name");
		String password = req.getParameter("pwd");
		inicio.loguearJugador(username, password);
		Jugador player = inicio.getJugador();
		Tienda tienda = inicio.getTienda();
		player.setMisContrincantes(tienda.getAllRobotsForCompetition());
		if(player != null){
			session.setAttribute("SstrUsuarioActual", player);
			req.getSession().setAttribute("player", player);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
//			resp.sendRedirect("http://localhost:8080/robot-web/index.jsp");
		}
	}
}

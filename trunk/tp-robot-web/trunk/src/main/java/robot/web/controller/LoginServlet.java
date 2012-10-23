package robot.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import robots.appModel.JugadorInicio;

import DominioRobot.Jugador;
import DominioRobot.Robot;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	JugadorInicio inicio = new JugadorInicio(null);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String username = req.getParameter("user_name");
		String password = req.getParameter("pwd");
		inicio.loguearJugador(username, password);
		Jugador player = inicio.getJugador();
		req.getSession().setAttribute("player", player);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}

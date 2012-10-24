package robot.web.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

import robots.appModel.JugadorInicio;

@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet{
	JugadorInicio taller = new JugadorInicio();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Collection<Robot> robotsParaLaVentas = taller.getTienda().getRobotsEnVenta();
		req.getSession().setAttribute("robotsContrincantes",robotsParaLaVentas);
	}
}

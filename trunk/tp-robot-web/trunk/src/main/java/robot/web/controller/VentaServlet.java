package robot.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DominioRobot.Robot;

import robots.appModel.JugadorInicio;

@SuppressWarnings("serial")
public class VentaServlet extends HttpServlet{
	JugadorInicio taller = new JugadorInicio(null);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idRobot = req.getParameter("id");
		Robot robot = taller.obtenerRobotDelJugador(Integer.parseInt(idRobot));
		taller.vender(robot);
		int nuevoSaldo;
	}
}

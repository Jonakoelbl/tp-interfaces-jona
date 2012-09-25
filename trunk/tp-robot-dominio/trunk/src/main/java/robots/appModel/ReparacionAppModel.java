package robots.appModel;

import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;

@Observable
public class ReparacionAppModel {
	public static final String COSTO = "costo";
	public static final String DETERIORO_A_REPARAR = "deterioroAReparar";
	
	private Jugador jugador;
	private Robot robotAReparar;
	private double deterioroAReparar;
	private double costo;
	
	public ReparacionAppModel(Jugador jugador, Robot robotSeleccionado) {
		this.jugador = jugador;
		this.robotAReparar = robotSeleccionado;
	}
	
	public void reparar(){
		this.jugador.reparar(this.robotAReparar);
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Robot getRobotAReparar() {
		return robotAReparar;
	}

	public void setRobotAReparar(Robot robotAReparar) {
		this.robotAReparar = robotAReparar;
	}

	public double getDeterioroAReparar() {
		this.setCosto(this.deterioroAReparar * 25);
		return deterioroAReparar;
	}

	public void setDeterioroAReparar(double deterioroAReparar) {
		this.deterioroAReparar = deterioroAReparar;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
}

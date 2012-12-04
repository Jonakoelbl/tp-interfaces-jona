package robots.appModel;

import java.io.Serializable;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;

@Observable
public class ReparacionAppModel implements Serializable{
	public static final String COSTO = "costo";
	public static final String DETERIORO_A_REPARAR = "deterioroAReparar";
	
	private Jugador jugador;
	private Robot robotAReparar;
	private int deterioroAReparar;
	private int costo;
	
	public ReparacionAppModel(Jugador jugador, Robot robotSeleccionado) {
		this.jugador = jugador;
		this.robotAReparar = robotSeleccionado;
	}
	
	public void reparar(){
		this.calcularCostoDeReparacion();
		this.validar();
		this.jugador.repararDeterioroDelRobot(this.robotAReparar, this.deterioroAReparar, this.costo);
	}
	
	public void validar(){
		if(this.jugador.getDinero() < this.costo)
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
		if(deterioroAReparar > getRobotAReparar().getNivelDeDeterioro())
			throw new UserException("El porcentaje a reparar supera al deterioro del robot");
		if (!this.ingresoNumero()) 
			throw new UserException("Debe ingresar número");
	}
	
	public boolean ingresoNumero() {
		return this.deterioroAReparar > 0;
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

	public int getDeterioroAReparar() {
		calcularCostoDeReparacion();
		return deterioroAReparar;
	}

	protected void calcularCostoDeReparacion() {
		this.setCosto(this.deterioroAReparar * 25);
	}

	public void setDeterioroAReparar(int deterioroAReparar) {
		this.deterioroAReparar = deterioroAReparar;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void validarCalculoCosto() {
		if(this.deterioroAReparar < 0)
			throw new UserException("El valor del costo debe ser mayor a 0");
	}
}

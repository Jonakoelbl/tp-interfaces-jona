package robots.appModel;

import java.io.Serializable;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class CompetirAppModel implements Serializable{
	
	public static final String ROBOT_SELECCIONADO = "robotSeleccionado";
	public static final String ROBOTS_DEL_JUGADOR = "robots";
	public static final String ROBOTS_EN_VENTA = "robotsEnVenta";
	public static final String ROBOTS_POSIBLES_CONTRINCANTES = "contrincantes";
	public static final String CONTRINCANTE_ELEGIDO = "contrincanteSeleccionado";
	public static final String APUESTA = "apuestaRealizada";
	
	private Jugador jugador;
	private Robot robotSeleccionado;
	private Robot contrincanteSeleccionado;
	private Integer apuestaRealizada;
	private Tienda tienda;// = new Tienda();


	public CompetirAppModel(Jugador unJugador, Robot unDesafiante, Tienda tienda) {
		this.robotSeleccionado = unDesafiante;
		this.setJugador(unJugador);
		this.tienda = tienda;
	}
	
	public CompetirAppModel(Jugador unJugador, Robot unDesafiante, Robot unContrincante, Tienda tienda) {
		this.robotSeleccionado = unDesafiante;
		this.setContrincanteSeleccionado(unContrincante);
		this.setJugador(unJugador);
		this.tienda = tienda;
	}
	/**
	 * 
	 */
	public void competirPorHonor(){
		this.validar();
		this.tienda.competir(this.apuestaRealizada, this.robotSeleccionado, this.contrincanteSeleccionado);
	}
	
	public void rechazarReto(){
		this.robotSeleccionado.desgaste();
	}
	
	public void validar(){
		if(this.contrincanteSeleccionado == null)
			throw new UserException("No se ha seleccionado un contrincante");
		if(this.apuestaRealizada == null)
			throw new UserException("No se ha ingresado una apuesta");
		if(this.apuestaRealizada > this.jugador.getDinero())
			throw new UserException("Su apuesta supera al monto del jugador");
	}
	
	public Robot getContrincanteSeleccionado() {
		return contrincanteSeleccionado;
	}
	public void setContrincanteSeleccionado(Robot contrincanteSeleccionado) {
		this.contrincanteSeleccionado = contrincanteSeleccionado;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Robot getRobotSeleccionado() {
		return robotSeleccionado;
	}
	public void setRobotSeleccionado(Robot robotSeleccionado) {
		this.robotSeleccionado = robotSeleccionado;
	}
	public Integer getApuestaRealizada() {
		return apuestaRealizada;
	}
	public void setApuestaRealizada(Integer apuestaRealizada) {
		this.apuestaRealizada = apuestaRealizada;
	}

}

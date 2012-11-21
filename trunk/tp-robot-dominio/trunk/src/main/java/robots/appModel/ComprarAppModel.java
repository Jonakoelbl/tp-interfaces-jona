package robots.appModel;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class ComprarAppModel implements Serializable{

	private Jugador jugador;
	private Robot robotAComprar;
	private Integer oferta;
	private Tienda tienda;

	public ComprarAppModel(Jugador jugador, Tienda tienda) {
		this.jugador = jugador;
		this.tienda = tienda;
	}
	
	public void comprar(){
		this.validar();
		this.tienda.venderleRobotAJugador(jugador, robotAComprar, oferta);
	}

	public List<Robot> getRobotsEnVenta(){
		return this.tienda.getRobotsEnVenta();
	}
	
	private void validar() {
		if(this.oferta == null)
			throw new UserException("No a ingresado una oferta");
		if(this.oferta <= 0)
			throw new UserException("El valor de la oferta es menor igual 0");
		if(this.robotAComprar == null)
			throw new UserException("No ha seleccionado un robot para comprar");
		if(this.jugador.getDinero() < this.oferta)
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() {
		return oferta;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Robot getRobotAComprar() {
		return robotAComprar;
	}

	public void setRobotAComprar(Robot robotAComprar) {
		this.robotAComprar = robotAComprar;
	}
}

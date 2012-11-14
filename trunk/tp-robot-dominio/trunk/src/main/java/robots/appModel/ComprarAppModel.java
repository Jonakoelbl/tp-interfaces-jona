package robots.appModel;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

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
	
	public void realizarOferta() {
//		Integer random = Math.random();
//		do{random = new Random().nextInt(20);}while(random <= 2);
//		this.setOferta(robotAComprar.getPrecio() * (random/100));
	}
	
	public void comprar(){
		this.validar();
		this.tienda.venderleRobot(jugador, robotAComprar, getOferta());
	}

	public List<Robot> getRobotsEnVenta(){
		return this.tienda.getRobotsEnVenta();
	}
	
	private void validar() {
		//TODO
//		if(this.oferta < 0)
//			throw 
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

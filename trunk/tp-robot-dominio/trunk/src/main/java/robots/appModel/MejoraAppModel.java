package robots.appModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class MejoraAppModel {
	
	private Robot robotAMejorar;
	private Jugador jugador;
	private Tienda tienda;
	private Mejora mejoraSeleccionado;
	
	public MejoraAppModel(Jugador jugador, Robot robotSeleccionado, Tienda tienda) {
		this.jugador = jugador;
		this.robotAMejorar = robotSeleccionado;
		this.tienda = tienda;
	}
	
	public void mejorar(){
		this.tienda.venderMejora(this.jugador, this.robotAMejorar, this.mejoraSeleccionado);
	}
	
	public List<Mejora> getMejorasEnVenta(){
		return this.tienda.getMejoras();
	}
	
	public void setRobotAMejorar(Robot robotAMejorar) {
		this.robotAMejorar = robotAMejorar;
	}
	public Robot getRobotAMejorar() {
		return robotAMejorar;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public Tienda getTienda() {
		return tienda;
	}

	public void setMejoraSeleccionado(Mejora mejoraSeleccionado) {
		this.mejoraSeleccionado = mejoraSeleccionado;
	}

	public Mejora getMejoraSeleccionado() {
		return mejoraSeleccionado;
	}
	
	
}

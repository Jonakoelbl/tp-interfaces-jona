package robots.appModel;

import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;

@Observable
public class ReparacionAppModel {
	public static final String DETERIORO_DEL_ROBOT = "deterioroDelRobot";
	public static final String REPARAR_DETERIORO = "repararDeterioro";
	
	private Jugador jugador;
	private Robot robotAReparar;
	private Integer repararDeterioro = 0;
	private Integer costo = 0;
	
	public ReparacionAppModel(Jugador jugador, Robot robot) {
		this.jugador = jugador;
		this.robotAReparar = robot;
	}
	
	public void calcularCosto(){
		
	}
	
	public Integer getDeterioroDelRobot(){
		return this.robotAReparar.getNivelDeDeterioro();
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setRobotAReparar(Robot robotAReparar) {
		this.robotAReparar = robotAReparar;
	}
	public Robot getRobotAReparar() {
		return robotAReparar;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public Integer getCosto() {
		return costo;
	}

	public void setRepararDeterioro(Integer repararDeterioro) {
		this.repararDeterioro = repararDeterioro;
	}

	public Integer getRepararDeterioro() {
		this.costo = this.jugador.calcularCostoDeReparacion(this.getDeterioroDelRobot());
		return repararDeterioro;
	}
}

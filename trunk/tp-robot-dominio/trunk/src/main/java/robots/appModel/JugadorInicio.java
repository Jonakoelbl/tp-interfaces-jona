package robots.appModel;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;

@Observable
public class JugadorInicio {
	
	public static final String ROBOT_SELECCIONADO = "robotSeleccionado";
	public static final String ROBOTS_DEL_JUGADOR = "robots";
	private Jugador jugador;
	private Robot robotSeleccionado;

	public JugadorInicio(Jugador jugador) {
		super();
		this.jugador = jugador;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public void vender(){
		this.getJugador().vender(this.getRobotSeleccionado());
		List<Robot> robots = this.getRobots();
		this.setRobots(null);
		this.setRobots(robots);
	}
	
	public void reparar(){
		this.getJugador().reparar(this.getRobotSeleccionado());
		
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
	
	public List<Robot> getRobots(){
		return this.jugador.getMisRobots();
	}
	
	public void setRobots(List<Robot> robots){
		this.jugador.setMisRobots(robots);
		ObservableUtils.forceFirePropertyChanged(this,"robots",this.getRobots());
	}
}

package robots.appModel;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class JugadorInicio {
	
	public static final String ROBOT_SELECCIONADO = "robotSeleccionado";
	public static final String ROBOTS_DEL_JUGADOR = "robots";
	public static final String ROBOTS_EN_VENTA = "robotsEnVenta";
	public static final String MEJORAS_EN_VENTA = "mejoras";
	public static final String MEJORA_SELECCIONADO = "mejoraSeleccionado";
	
	private Jugador jugador;
	private Robot robotSeleccionado;
	private Tienda tienda = new Tienda();
	private Mejora mejoraSeleccionado;

	public JugadorInicio(Jugador jugador) {
		super();
		this.jugador = jugador;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public void vender(){
		this.tienda.comprarRobot(this.jugador, this.robotSeleccionado, this.tienda.getOferta());
		List<Robot> robots = this.getRobots();
		this.setRobots(null);
		this.setRobots(robots);
	}
	
	public void mejorar(){
		//XXX validar
		this.tienda.venderMejora(this.jugador, this.robotSeleccionado, this.mejoraSeleccionado);
	}
	
	public void comprar(){
		this.tienda.venderleRobot(this.jugador, this.robotSeleccionado, this.tienda.getOferta());
	}
	
	public void reparar(){
		this.getJugador().reparar(this.getRobotSeleccionado());
	}
	
	public void realizarOferta(){
		this.tienda.realizarOferta(this.robotSeleccionado);
	}
	
	///////***********/////
	/////// ASSESORS  /////
	///////////////////////
		
	public Integer costo(){
		return this.jugador.getCosto();
	}
	
	public Integer getReparaDeterioro(){
		return this.jugador.getRepararDeterioro();
	}
	public void setRepararDeterioro(Integer deterioro){
		this.jugador.setRepararDeterioro(deterioro);
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Robot getRobotSeleccionado() {
		return robotSeleccionado;
	}
	
	public List<Mejora> getMejoras(){
		return this.tienda.getMejoras();
	}
	
	public List<Robot> getRobotsEnVenta(){
		return this.tienda.getRobotsEnVenta();
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

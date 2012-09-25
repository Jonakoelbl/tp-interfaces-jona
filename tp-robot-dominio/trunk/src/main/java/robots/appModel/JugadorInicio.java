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
	public static final String ROBOTS_POSIBLES_CONTRINCANTES = "contrincantes";
	public static final String CONTRINCANTE_ELEGIDO = "contrincanteSeleccionado";
	public static final String APUESTA = "apuestaRealizada";
	
	private Jugador jugador;
	private Robot robotSeleccionado;
	private Robot contrincanteSeleccionado;
	private Integer apuestaRealizada;
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
		List<Robot> robots = this.getRobotsEnVenta();
		this.setRobots(null);
		this.setRobots(robots);
	}
	
	public void darOfertaDeUnRobot(){
		this.tienda.realizarOferta(this.robotSeleccionado);
	}
	/**
	 * Here the system must be return the user that init session
	 */
	public void realizarOferta(){
		this.tienda.venderleRobotAJugador(this.jugador, this.robotSeleccionado, this.tienda.getOferta());
		ObservableUtils.forceFirePropertyChanged(this, "robotsEnVenta", this.getRobotsEnVenta());
		ObservableUtils.forceFirePropertyChanged(this, "contrincantes", this.getRobotsEnVenta());
	}
	
	///////***********/////
	/////// ASSESORS  /////
	///////////////////////
		
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Robot getRobotSeleccionado() {
		return robotSeleccionado;
	}

	public Integer getApuestaRealizada() {
		return apuestaRealizada;
	}

	public void setApuestaRealizada(Integer apuestaRealizada) {
		this.apuestaRealizada = apuestaRealizada;
	}

	/**
	 * 
	 * @return the list of robots 
	 */
	public List<Robot> getContrincantes(){
		return this.tienda.getAllRobotsForCompetition();
	}
	public void setContrincantes(List<Robot> robots){
		this.tienda.setRobotsEnCompetencia(robots);
		ObservableUtils.forceFirePropertyChanged(this,"contrincantes",this.getContrincantes());
		ObservableUtils.forceFirePropertyChanged(this,"robots",this.getContrincantes());
	}
	public List<Mejora> getMejoras(){
		return this.tienda.getMejoras();
	}
	public List<Robot> getRobotsDelSistema(){
		return this.tienda.getRobotsEnVenta();
	}
	
	public void setRobotsEnVenta(List<Robot> robots){
		this.tienda.setRobotsEnVenta(robots);
		ObservableUtils.forceFirePropertyChanged(this, "robotsEnVenta", this.getRobotsEnVenta());
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

	public Robot getContrincanteSeleccionado() {
		return contrincanteSeleccionado;
	}

	public void setContrincanteSeleccionado(Robot contrincanteSeleccionado) {
		this.contrincanteSeleccionado = contrincanteSeleccionado;
	}
}

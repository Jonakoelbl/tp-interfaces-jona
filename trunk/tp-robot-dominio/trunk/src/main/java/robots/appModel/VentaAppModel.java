package robots.appModel;

import java.util.List;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

public class VentaAppModel {
	public static final String JUGADOR = "jugador";
	public static final String ROBOT_NOMBRE= "robotNombre";
	public static final String ESTADO = "nivelDeDeterioro";
	public static final String PRECIO = "precio";
	public static final String OFERTA_DEL_SISTEMA = "ofertaDelSistema";
	
	private Jugador jugador;
	private Robot robotAVender;
	private Integer ofertaDelSistema;
	private Tienda tienda;
	private JugadorInicio model;
	
	public VentaAppModel(JugadorInicio model, Jugador jugador, Robot robotSeleccionado) {
		this.jugador = jugador;
		this.robotAVender = robotSeleccionado;
		this.model = model;
	}
	
	public void vender(){
		this.tienda.comprarRobot(this.jugador, this.robotAVender, this.ofertaDelSistema);
		List<Robot> robots = this.model.getRobots();
		this.model.setRobots(null);
		this.model.setRobots(robots);
	}
	
	public void generarOferta(){
		this.tienda.realizarOferta(robotAVender);
	}
	
	public Integer getPrecio(){
		return this.robotAVender.getPrecio();
	}
	
	public Integer getNivelDeDeterioro(){
		return this.robotAVender.getNivelDeDeterioro();
	}
	
	public String getRobotNombre(){
		return this.robotAVender.getNombreRobot();
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Robot getRobotAVender() {
		return robotAVender;
	}
	public void setRobotAVender(Robot robotAVender) {
		this.robotAVender = robotAVender;
	}
	public Integer getOfertaDelSistema() {
		return this.tienda.getOferta();
	}
	public void setOfertaDelSistema(Integer ofertaDelSistema) {
		this.ofertaDelSistema = ofertaDelSistema;
	}
}
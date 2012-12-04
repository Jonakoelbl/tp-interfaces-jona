package robots.appModel;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class VentaAppModel implements Serializable{
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
	
	public VentaAppModel(JugadorInicio model, Jugador jugador, Robot robotSeleccionado, Tienda tienda) {
		this.jugador = jugador;
		this.robotAVender = robotSeleccionado;
		this.model = model;
		this.tienda = tienda;
	}
	
	/**
	 * Constructor para wicket
	 */
	public VentaAppModel(Jugador jugador2, Robot robotAVender2, Tienda tienda2) {
		this.jugador = jugador2;
		this.robotAVender = robotAVender2;
		this.tienda = tienda2;
	}

	public void vender(){
		this.tienda.comprarRobot(this.jugador, this.robotAVender, this.ofertaDelSistema);
	}
	
	public void venderArena(){
		this.tienda.comprarRobot(this.jugador, this.robotAVender, this.ofertaDelSistema);
		List<Robot> robots = this.model.getRobots();
		this.model.setRobots(null);
		this.model.setRobots(robots);
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
		Integer ofertaCalculada = this.tienda.calcularOferta(robotAVender) ;
		this.setOfertaDelSistema(ofertaCalculada);
		return ofertaCalculada;
	}
	public void setOfertaDelSistema(Integer ofertaDelSistema) {
		this.ofertaDelSistema = ofertaDelSistema;
	}

	public void rechazarCompra() {
		this.robotAVender.desgaste();
	}
}

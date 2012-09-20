package robots.appModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class TiendaAppModel {
	public static final String JUGADOR = "jugador";
	public static final String ROBOT_SELECCIONADO = "robot";
	public static final String MEJORA_SELECCIONADO = "mejoraSeleccionado";
	public static final String TIENDA = "tienda";
	public static final String OFERTA = "oferta";
	
	private Jugador jugador;
	private Robot robotSeleccionado;
	private Mejora mejoraSelecccionado;
	private Integer oferta; 
	private Tienda tienda;
	
	public TiendaAppModel(Jugador jugador, Robot robot) {
		this.jugador = jugador;
		this.robotSeleccionado = robot;
	}
	
	public void mejorar(){
		//XXX validar
		this.tienda.venderMejora(this.jugador, this.robotSeleccionado, this.mejoraSelecccionado);
	}
	
	public void comprar(){
		//XXX validar
		this.tienda.comprarRobot(this.jugador, this.robotSeleccionado, this.oferta);
	}
		
	public void realizarOferta(){
		this.oferta = this.tienda.realizarOferta(this.robotSeleccionado);
	}
	
	public String getNombreRobot(){
		return this.robotSeleccionado.getNombreRobot();
	}
	
	public Integer getNivelDeterioro(){
		return this.robotSeleccionado.getNivelDeDeterioro();
	}
	
	public Integer getPrecioRobot(){
		return this.robotSeleccionado.getPrecio();
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public Robot getRobot() {
		return robotSeleccionado;
	}
	public void setRobot(Robot robot) {
		this.robotSeleccionado = robot;
	}
	public Mejora getMejoraSelecccionado() {
		return mejoraSelecccionado;
	}
	public void setMejoraSelecccionado(Mejora mejoraSelecccionado) {
		this.mejoraSelecccionado = mejoraSelecccionado;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() {
		return oferta;
	}
}

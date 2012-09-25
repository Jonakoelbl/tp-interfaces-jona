package DominioRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uqbar.commons.utils.Observable;

@Observable
public class Robot {
	public static final String 
		NOMBRE_ROBOT = "nombreRobot",
		PROPIETARIO = "propietario",
		NIVEL_DE_DETERIORO = "nivelDeDeterioro",
		PODER_EFECTIVO = "poderEfectivo",
		PODER = "poder",
		PRECIO = "precio",
		OFERTA = "oferta";
	
	private String nombreRobot;
	private Jugador propietario = null;
	private List<Mejora> actualizaciones = new ArrayList<Mejora>();
	private Integer nivelDeDeterioro = 0;
	private Integer poderEfectivo;
	private Integer poder ;
	private Integer precio;
	private Integer oferta;
	
	public Robot(String nombre) {
		this.nombreRobot = nombre;
		this.poder = new Random().nextInt(20);
		this.poderEfectivo = poder * (100 - this.nivelDeDeterioro) / 100;
		this.precio = this.poderEfectivo * 50;
	}
	
	public void actualizarPoder(Mejora mejora) {
		this.poder += mejora.getMejoraDePoder();
		this.actualizaciones.add(mejora);
	}
	
	public void fuisteReparado(Integer puntoAReparar){
		this.nivelDeDeterioro -= puntoAReparar;
	}
	
	public void fuisteComprado(Jugador jugador){
		this.setPropietario(jugador);
	}
	
	public void fuisteVendido() {
		this.propietario = null;
	}
	//GETTERS AND SETTERS //
	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setNivelDeDeterioro(Integer performance) {
		this.nivelDeDeterioro = performance;
	}

	public Integer getNivelDeDeterioro() {
		return nivelDeDeterioro;
	}

	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public Jugador getPropietario() {
		return propietario;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getPoder() {
		return poder;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public void setPoderEfectivo(Integer poderEfectivo) {
		this.poderEfectivo = poderEfectivo;
	}

	public Integer getPoderEfectivo() {
		return poderEfectivo;
	}
	
	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() { 
		return oferta;
	}


}

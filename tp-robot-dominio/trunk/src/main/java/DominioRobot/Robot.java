package DominioRobot;

import org.uqbar.commons.utils.Observable;

@Observable
public class Robot {
	private String nombreRobot;
	private String propietario;
	private Integer performance = 100;
	private Integer poder = 50;
	private Integer precio = 150;
	
	public Robot(String nombre) {
		this.setNombreRobot(nombre);
	}
	
	public void darlePropietario(Jugador jg){
		this.setPropietario(jg.getNombre());
	}

	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setPerformance(Integer performance) {
		this.performance = performance;
	}

	public Integer getPerformance() {
		return performance;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getPropietario() {
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
	
}

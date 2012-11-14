package DominioRobot;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Mejora implements Serializable{
	public static final String DESCRIPCION = "descripcion";
	public static final String MEJORA_DE_PODER = "mejoraDePoder";
	public static final String PRECIO = "precio";
	
	private String descripcion;
	private Integer mejoraDePoder;
	private Integer precio;
	
	public Mejora(String descripcion, Integer mejora, Integer precio) {
		this.setDescripcion(descripcion); 
		this.setMejoraDePoder(mejora);
		this.setPrecio(precio);
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setMejoraDePoder(Integer mejoraDePoder) {
		this.mejoraDePoder = mejoraDePoder;
	}

	public Integer getMejoraDePoder() {
		return mejoraDePoder;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPrecio() {
		return precio;
	}
	
	
}

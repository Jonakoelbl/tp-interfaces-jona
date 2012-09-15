package DominioRobot;

import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Mejora{
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

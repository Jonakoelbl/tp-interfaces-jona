package DominioRobot;

public class Sistema {
	
	private static Sistema INSTANCIA = new Sistema(); 
	
	/**
	 * Sistema es un singleton
	 */
	private Sistema(){}
	
	public static Sistema getInstancia(){return INSTANCIA;}
	
	public void reparar(Robot unRobot, Jugador unJugador){
		//TODO: agregar exception cuando el usuario no tiene dinero
		Integer costo = 100 - unRobot.getPerformance();
		unJugador.pagarGasto(costo);
		unRobot.setPerformance(100);
	}
}

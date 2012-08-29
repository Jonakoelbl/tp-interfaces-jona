package DominioRobot;

public class Sistema {
	
	private static Sistema INSTANCIA = new Sistema(); 
	
	/**
	 * Sistema es un singleton
	 */
	private Sistema(){}
	
	public static Sistema getInstancia(){return INSTANCIA;}
	
	public void reparar(Robot unRobot, Jugador unJugador){
		Integer costo = 100 - unRobot.getPerformance();
		unJugador.setDinero(costo - unJugador.getDinero());
		unRobot.setPerformance(100);
	}
}

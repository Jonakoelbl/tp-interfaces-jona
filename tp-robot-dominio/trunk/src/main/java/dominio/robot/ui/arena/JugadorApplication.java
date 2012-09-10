package dominio.robot.ui.arena;


import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;

import DominioRobot.Jugador;
import DominioRobot.Robot;

public class JugadorApplication extends MainWindow<Jugador> {
	
	private static Jugador jugador = new Jugador("Sr X");
	
	public JugadorApplication() {
		super(jugador);
	}
	
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Panel Jugador");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label nombreJugador = new Label(primerPanel);
		nombreJugador.bindValueToProperty("nombre");
		
		Label dinero = new Label(primerPanel);
		dinero.bindValueToProperty("dinero");
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label misRobots = new Label(segundoPanel);
		misRobots.setText("Mis Robots     ");
		crearBoton(segundoPanel, "Comprar", "aComprar");
	
		Panel tercerPanel = creacionDeColumnaJugador(mainPanel);
		
		Panel cuartoPanel = new Panel(tercerPanel).setLayout(new VerticalLayout());
		crearBoton(cuartoPanel, "Reparar", "aReparar");
		crearBoton(cuartoPanel, "Mejorar", "aMejorar");
		crearBoton(cuartoPanel, "Vender", "aVender");
		
		Label otrosRobots = new Label(mainPanel);
		otrosRobots.setText("Contrincantes");
		
		
		Panel quintoPanel = new Panel(mainPanel);
		quintoPanel.setHorizontalLayout();
		
	}

	private void crearBoton(Panel panel, String caption, String nombreMetodo ) {
		new Button(panel)
			.setCaption(caption)
			.onClick(new MessageSend(this, nombreMetodo));
	}

	private Panel creacionDeColumnaJugador(Panel mainPanel) {
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Table<Robot> table = new Table<Robot>(segundoPanel, Robot.class);
		table.bindContentsToProperty("misRobots");
		table.bindSelection("robotSeleccionado");
		
		Column<Robot> nombreColumna = new Column<Robot>(table);
		nombreColumna.setTitle("nombre del Robot");
		nombreColumna.setFixedSize(150);
		nombreColumna.bindContentsToProperty("nombreRobot");
		
		Column<Robot> poderColumna = new Column<Robot>(table);
		poderColumna.setTitle("Poder de ataque");
		poderColumna.setFixedSize(150);
		poderColumna.bindContentsToProperty("poder");
		
		Column<Robot> performanceColumna = new Column<Robot>(table);
		performanceColumna.setTitle("Performance");
		performanceColumna.setFixedSize(200);
		performanceColumna.bindContentsToProperty("performance");
		
		//table.setWidth(500).setHeigth(200);
		return segundoPanel;
	}
	
	public void aReparar(){
		this.openDialog(new SistemaReparacionWindow(this, jugador), "repararSeleccionado");
	}
	
	public void aMejorar(){
		this.openDialog(new SistemaMejoraWindow(this, jugador), "mejorarSeleccionado");
	}
	
	public void aVender(){
		this.openDialog(new SistemaVentaWindow(this,jugador), "venderSeleccionado");
	}
	
	public void aComprar(){
		this.openDialog(new SistemaVentaWindow(this,jugador), "comprarSeleccion");
	}
	
	protected void openDialog(Dialog<?> dialog, String nombreMetodo){
		dialog.onAccept(new MessageSend(this.getModelObject(), nombreMetodo));
		dialog.open();
	}
	
	public static void main(String[] args) {
		new JugadorApplication().startApplication();
	}



}

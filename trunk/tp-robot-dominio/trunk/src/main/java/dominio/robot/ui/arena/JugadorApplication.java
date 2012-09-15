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
	
	public JugadorApplication() {
		super(new Jugador("Jona"));
	}
	
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Panel Jugador");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label nombreJugador = new Label(primerPanel);
		nombreJugador.bindValueToProperty(Jugador.NOMBRE);
		
		Label dinero = new Label(primerPanel);
		dinero.bindValueToProperty(Jugador.DINERO);
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label misRobots = new Label(segundoPanel);
		misRobots.setText("Mis Robots     ");
		crearBoton(segundoPanel, "Comprar", "aComprar");
	
		Panel tercerPanel = creacionDeColumnaJugador(mainPanel);
		
		Panel cuartoPanel = new Panel(tercerPanel).setLayout(new VerticalLayout());
		crearBoton(cuartoPanel, "Reparar", "repararElRobot");			
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
		Panel panel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Table<Robot> table = new Table<Robot>(panel, Robot.class);
		table.bindItemsToProperty("misRobots");
		table.bindSelection(Jugador.ROBOT_SELECCIONADO);
		
		Column<Robot> nombreColumna = new Column<Robot>(table);
		nombreColumna.setTitle("Nombre del robot");
		nombreColumna.setFixedSize(150);
		nombreColumna.bindContentsToProperty(Robot.NOMBRE_ROBOT);
		
		Column<Robot> poderColumna = new Column<Robot>(table);
		poderColumna.setTitle("Poder de ataque");
		poderColumna.setFixedSize(150);
		poderColumna.bindContentsToProperty(Robot.PODER);
		
		Column<Robot> performanceColumna = new Column<Robot>(table);
		performanceColumna.setTitle("Nivel de deterioro");
		performanceColumna.setFixedSize(200);
		performanceColumna.bindContentsToProperty(Robot.NIVEL_DE_DETERIORO);
		
		//table.setWidth(500).setHeigth(200);
		return panel;
	}

	public void repararElRobot(){
		this.openDialog(new SistemaReparacionWindow(this, this.getModelObject()),"repararUnRobot");
	}
	
	public void aMejorar(){
		this.openDialog(new SistemaMejoraWindow(this, this.getModelObject().getRobotSeleccionado()), "mejorarUnRobot");
	}
	
	public void aVender(){
		this.openDialog(new SistemaVentaWindow(this,this.getModelObject().getRobotSeleccionado()), "venderUnRobot");
	}
	
	public void aComprar(){
		this.openDialog(new SistemaVentaWindow(this,this.getModelObject().getRobotSeleccionado()), "comprarSeleccion");
	}
	
	protected void openDialog(Dialog<?> dialog, String nombreMetodo){
		dialog.onAccept(new MessageSend(this.getModelObject(), nombreMetodo));
		dialog.open();
	}
	
	public static void main(String[] args) {
		new JugadorApplication().startApplication();
	}



}

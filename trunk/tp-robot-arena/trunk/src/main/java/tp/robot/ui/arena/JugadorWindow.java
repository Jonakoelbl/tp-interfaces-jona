package tp.robot.ui.arena;


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
import org.uqbar.commons.model.UserException;

import robots.appModel.CompetirAppModel;
import robots.appModel.JugadorInicio;
import robots.appModel.ReparacionAppModel;
import robots.appModel.VentaAppModel;
import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;

public class JugadorWindow extends MainWindow<JugadorInicio> {
	public JugadorWindow() {
		super(new JugadorInicio(new Tienda().getJugadores().get(0)));
	}
	
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Panel Jugador");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label nombreJugador = new Label(primerPanel);
		nombreJugador.bindValueToProperty("jugador.nombre");
		
		Label dinero = new Label(primerPanel);
		dinero.bindValueToProperty("jugador.dinero");
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Label misRobots = new Label(segundoPanel);
		misRobots.setText("Mis Robots     ");
		crearBoton(segundoPanel, "Comprar", "comprarUnRobot");
	
		Panel tercerPanel = this.crearTablaDeRobots(mainPanel);
		
		Panel cuartoPanel = new Panel(tercerPanel).setLayout(new VerticalLayout());
		crearBoton(cuartoPanel, "Reparar", "repararElRobot");			
		crearBoton(cuartoPanel, "Mejorar", "mejorarUnRobot");
		crearBoton(cuartoPanel, "Vender", "venderUnRobot");
		
		Label otrosRobots = new Label(mainPanel);
		otrosRobots.setText("Contrincantes");
		Panel sextoPanel = this.crearTablaDeRobotsContrincantes(mainPanel);
		crearBoton(sextoPanel, "Competir", "introducirApuesta");
		
		
		Panel quintoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
	}

	private void crearBoton(Panel panel, String caption, String nombreMetodo ) {
		new Button(panel)
			.setCaption(caption)
			.onClick(new MessageSend(this, nombreMetodo));
	}

	private Panel crearTablaDeRobots(Panel mainPanel) {
		Panel panel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		Table<Robot> table = new Table<Robot>(panel, Robot.class);
		table.bindItemsToProperty(JugadorInicio.ROBOTS_DEL_JUGADOR);
		table.bindSelection(JugadorInicio.ROBOT_SELECCIONADO);
		
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
		
		table.setWidth(500).setHeigth(100);
		return panel;
	}
	/**
	 * 
	 * @param mainPanel
	 * @return
	 */
	private Panel crearTablaDeRobotsContrincantes(Panel mainPanel) {
		Panel panel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		Table<Robot> table = new Table<Robot>(panel, Robot.class);
		table.bindItemsToProperty(JugadorInicio.ROBOTS_POSIBLES_CONTRINCANTES);
		table.bindSelection(JugadorInicio.CONTRINCANTE_ELEGIDO);

		Column<Robot> propietarioColumna = new Column<Robot>(table);
		propietarioColumna.setTitle("Propietario");
		propietarioColumna.setFixedSize(150);
		propietarioColumna.bindContentsToProperty(Robot.PROPIETARIO);
		
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
		
		table.setWidth(500).setHeigth(200);
		return panel;
	}
	

	public void repararElRobot(){
		ReparacionAppModel model = new ReparacionAppModel(this.getModelObject().getJugador(), this.getModelObject().getRobotSeleccionado());
		Dialog<?> dialog = new SistemaReparacionWindow(this, model);
		dialog.onAccept(null);
		dialog.open();
		//this.openDialog(new SistemaReparacionWindow(this, this.getModelObject()),"reparar");
	}
	
	public void mejorarUnRobot(){
		this.openDialog(new SistemaMejoraWindow(this, this.getModelObject()), "mejorar");
	}
	public void introducirApuesta(){
		CompetirAppModel model = new CompetirAppModel(this.getModelObject().getJugador(), this.getModelObject().getRobotSeleccionado(), this.getModelObject().getContrincanteSeleccionado());
		Dialog<?> dialog = new SistemaCompetirWindow(this, model);
		dialog.open();
		//this.openDialog(new SistemaCompraWindow(this,this.getModelObject()), "comprar");
	}
	
	public void venderUnRobot(){
		JugadorInicio jug = this.getModelObject();
		VentaAppModel model = new VentaAppModel(jug, jug.getJugador(),jug.getRobotSeleccionado() ,jug.getTienda());
		Dialog<?> dialog = new SistemaVentaWindow(this, model);
		dialog.open();
		//SistemaVentaWindow venderRobot = new SistemaVentaWindow(this, this.getModelObject());
		//this.openDialog(venderRobot, "vender");
	}
	 
	public void comprarUnRobot(){
		this.openDialog(new SistemaCompraWindow(this,this.getModelObject()), "comprar");
	}
	/**
	 * 
	 * @param dialog 
	 * @param nombreMetodo
	 */

	protected void openDialog(Dialog<?> dialog, String nombreMetodo){
		dialog.onAccept(new MessageSend(this.getModelObject(), nombreMetodo));
		dialog.open();
	}
	
	public static void main(String[] args) {
		new JugadorWindow().startApplication();
	}



}

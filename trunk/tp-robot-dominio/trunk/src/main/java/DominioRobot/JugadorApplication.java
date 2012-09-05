package DominioRobot;


import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

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
		nombreJugador.bindValueToProperty("nombre");
		
		Label dinero = new Label(primerPanel);
		dinero.bindValueToProperty("dinero");
		
		Label misRobots = new Label(mainPanel);
		misRobots.setText("Mis Robots");
		
		Panel segundoPanel = creacionDeColumnaJugador(mainPanel);
		
		Button reparar = new Button(segundoPanel);
		reparar.setCaption("Reparar");
		reparar.onClick(new MessageSend(this.getModelObject(), "repararSeleccionado"));
		
		Label otrosRobots = new Label(mainPanel);
		otrosRobots.setText("Otros Robots");
		
		Panel tercerPanel = new Panel(mainPanel);
		tercerPanel.setHorizontalLayout();
		
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
		
		table.setWidth(500).setHeigth(200);
		return segundoPanel;
	}
	
	public static void main(String[] args) {
		new JugadorApplication().startApplication();
	}



}

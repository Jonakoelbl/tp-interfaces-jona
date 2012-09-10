package dominio.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Jugador;


public class SistemaReparacionWindow extends TransactionalDialog<Jugador>{

	public SistemaReparacionWindow(WindowOwner owner, Jugador jugadorModel) {
		super(owner, jugadorModel);
	}
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Reparacion");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Performance del Robot");
		new Label(primerPanel).bindValueToProperty("performanceRobotSeleccionado");
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(segundoPanel).setText("Performance a reparar");
		new TextBox(segundoPanel).bindValueToProperty("performanceAReparar");
		//TODO que el costo se calcule automaticamente cuando se le ingresa valores al textbox
		
		Panel tercerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(tercerPanel).setText("costo");
		new Label(tercerPanel).bindValueToProperty("costo");
	}
	//TODO ver bien el tema de los accept/cancel 
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
		.setCaption("Aceptar")
		.onClick(new MessageSend(this, "accept"))
		.setAsDefault()
		.disableOnError();

		new Button(actions) //
		.setCaption("Cancelar")
		.onClick(new MessageSend(this, "cancel"));

	}
}

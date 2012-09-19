package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import robots.appModel.ReparacionAppModel;

import DominioRobot.Jugador;


public class SistemaReparacionWindow extends TransactionalDialog<ReparacionAppModel>{

	public SistemaReparacionWindow(WindowOwner owner, ReparacionAppModel model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Reparacion");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Deterioro del Robot");
		new Label(primerPanel).bindValueToProperty(Jugador.DETERIORO_DEL_ROBOT);
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(segundoPanel).setText("Reparar deterioro");
		new TextBox(segundoPanel).bindValueToProperty(Jugador.REPARAR_DETERIORO);
		
		Panel tercerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(tercerPanel).setText("costo");
		new Label(tercerPanel).bindValueToProperty(Jugador.COSTO);
	}
	
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

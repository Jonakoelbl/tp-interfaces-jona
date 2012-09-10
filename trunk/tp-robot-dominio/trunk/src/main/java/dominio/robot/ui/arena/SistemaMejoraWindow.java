package dominio.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Jugador;

public class SistemaMejoraWindow extends TransactionalDialog<Jugador>{
	
	public SistemaMejoraWindow(WindowOwner owner, Jugador jugadorModel) {
		super(owner, jugadorModel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Mejora");
		mainPanel.setVerticalLayout();
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Poder de ");
		
		
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

package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Robot;

public class SistemaVentaWindow extends TransactionalDialog<Robot>{

	public SistemaVentaWindow(WindowOwner owner, Robot model) {
		super(owner, model);
		model.pedirOferta();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Venta");
		mainPanel.setLayout(new VerticalLayout());
		
		labelBind(mainPanel, "Nombre:         ", Robot.NOMBRE_ROBOT);
		labelBind(mainPanel, "Estado:         ", Robot.NIVEL_DE_DETERIORO);
		labelBind(mainPanel, "Precio original:", Robot.PRECIO);
		labelBind(mainPanel, "OFERTA:         ", Robot.OFERTA);
		
	}

	protected void labelBind(Panel mainPanel, String text, String property) {
		Panel newPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(newPanel).setText(text);
		new Label(newPanel).bindValueToProperty(property);
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

package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import robots.appModel.TiendaAppModel;

import DominioRobot.Robot;

public class SistemaVentaWindow extends TransactionalDialog<TiendaAppModel>{

	public SistemaVentaWindow(WindowOwner owner, TiendaAppModel model) {
		super(owner, model);
		model.realizarOferta();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Venta");
		mainPanel.setLayout(new VerticalLayout());
		
		labelBind(mainPanel, "Nombre:         ", "nombre");
		labelBind(mainPanel, "Estado:         ", "nivelDeDeterioro");
		labelBind(mainPanel, "Precio original:", "precio");
		labelBind(mainPanel, "OFERTA:         ", "oferta");
		
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

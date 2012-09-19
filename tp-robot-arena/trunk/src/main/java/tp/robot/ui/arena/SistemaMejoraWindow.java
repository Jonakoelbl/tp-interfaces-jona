package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Mejora;
import DominioRobot.Robot;

public class SistemaMejoraWindow extends TransactionalDialog<Robot>{
	
	public SistemaMejoraWindow(WindowOwner owner, Robot model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Mejora");
		mainPanel.setVerticalLayout();
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Poder de ");
		new Label(primerPanel).bindValueToProperty(Robot.NOMBRE_ROBOT);
		new Label(primerPanel).bindValueToProperty(Robot.PODER);
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		Table<Mejora> table = new Table<Mejora>(segundoPanel,Mejora.class);
		table.bindItemsToProperty("");
		table.bindSelection(Robot.MEJORA_SELECCIONADA);
	
		Column<Mejora> performanceColumna = new Column<Mejora>(table);
		performanceColumna.setTitle("Descripcion");
		performanceColumna.setFixedSize(200);
		performanceColumna.bindContentsToProperty("descripcion");
		
		Column<Mejora> nombreColumna = new Column<Mejora>(table);
		nombreColumna.setTitle("Mejora del poder");
		nombreColumna.setFixedSize(150);
		nombreColumna.bindContentsToProperty("mejoraDelPoder");
		
		Column<Mejora> poderColumna = new Column<Mejora>(table);
		poderColumna.setTitle("Precio");
		poderColumna.setFixedSize(150);
		poderColumna.bindContentsToProperty("precio");
		
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

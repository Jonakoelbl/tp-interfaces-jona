package dominio.robot.ui.arena;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Jugador;

public class SistemaVentaWindow extends TransactionalDialog<Jugador>{

	public SistemaVentaWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
	}

}

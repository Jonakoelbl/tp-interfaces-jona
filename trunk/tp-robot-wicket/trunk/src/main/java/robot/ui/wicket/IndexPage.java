package robot.ui.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;

import DominioRobot.Jugador;
import DominioRobot.Robot;

import robots.appModel.IndexJugador;

public class IndexPage extends WebPage{
	
	private static final long serialVersionUID = 1l;
	
	private final IndexJugador indexJugador;
	
	public IndexPage() {
		this.indexJugador = new IndexJugador();
		Form<IndexJugador> indexJugador = new Form<IndexJugador>("IndexJugadorForm",new CompoundPropertyModel<IndexJugador>(this.indexJugador));
		this.createLabelUsernameAndMoney(indexJugador);
		this.createButtonComprar(indexJugador);
		this.createTableRobotPlayer(indexJugador);
		this.add(indexJugador);
	}
	
	protected void createLabelUsernameAndMoney(Form<IndexJugador> form){
		form.add(new Label("jugador.nombre"));
		form.add(new Label("jugador.dinero"));
	}
	
	private void createTableRobotPlayer(Form<IndexJugador> parent) {
		parent.add(new PropertyListView<Robot>("robotsDelJugador") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Robot> item) {
				item.add(new Label("nombreRobot"));
				item.add(new Label("poder"));
				item.add(new Label("nivelDeDeterioro"));
				
				item.add(createButtonReparar(item.getModelObject()));
				item.add(createButtonVender(item.getModelObject()));
				item.add(createButtonMejora(item.getModelObject()));
				item.add(createButtonCompetir(item.getModelObject()));
			}
		});
	}
	
	protected Component createButtonCompetir(final Robot robot) {
		return new Button("Competir"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonCompetir(robot);
			}
		};
	}
	
	protected void goToButtonCompetir(Robot robotPlayer) {
		CompetirPage competirPage = new CompetirPage(this.indexJugador, robotPlayer, this);
		this.setResponsePage(competirPage);
	}
	
	protected Component createButtonMejora(final Robot robot) {
		return new Button("Mejorar") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonMejorar(robot);
			}
		};
	}
	
	protected void goToButtonMejorar(Robot robotAMejorar){
		MejoraPage mejoraPage = new MejoraPage(this.indexJugador,robotAMejorar, this);
		this.setResponsePage(mejoraPage);
	}

	protected Component createButtonVender(final Robot robot) {
		return new Button("Vender") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonVender(robot);
			}
		};		
	}

	protected void goToButtonVender(Robot robotAVender) {
		VenderPage venderPage = new VenderPage(this.indexJugador,robotAVender, this);
		this.setResponsePage(venderPage);
	}

	protected Component createButtonReparar(final Robot robot){
		return new Button("Reparar") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonReparar(robot);
			}
		};
	}

	protected void goToButtonReparar(Robot robotAReparar) {
		RepararPage repararPage = new RepararPage(robotAReparar,this.indexJugador.getJugador(), this);
		this.setResponsePage(repararPage);
	}

	protected void createButtonComprar(Form<IndexJugador> form){
		form.add(new Button("Comprar") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonComprar();
			}			
		});
	}

	protected void goToButtonComprar() {
		ComprarPage comprarPage = new ComprarPage(this, this.indexJugador);
		this.setResponsePage(comprarPage);
	}

}
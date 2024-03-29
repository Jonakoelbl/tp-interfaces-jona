package robot.ui.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import DominioRobot.Robot;

import robot_ui_wicket.robot_ui_wicketweb.FormManageException;
import robots.appModel.CompetirAppModel;
import robots.appModel.IndexJugador;

public class CompetirPage extends WebPage {
	
	private static final long serialVersionUID = 1l;
	
	private final CompetirAppModel battleground;
	private final IndexPage mainPage;
	private final List<Robot> robotsPreparedToFight;
	
	public CompetirPage(IndexJugador indexJugador, Robot robotPlayer, IndexPage mainPage) {
		this.mainPage = mainPage;
		this.robotsPreparedToFight = indexJugador.getRobotsDeLosContrincantes();
		this.battleground = new CompetirAppModel(indexJugador.getJugador(), robotPlayer, indexJugador.getTienda());
		Form<CompetirAppModel> competirForm = 
			new FormManageException<CompetirAppModel>("competirForm", new CompoundPropertyModel<CompetirAppModel>(this.battleground));
		this.createTextOfFieldApuesta(competirForm);
		this.createTableRobotsPreparedToFight(competirForm);
		this.createButton(competirForm);
		this.add(competirForm);
	}
	
	protected void createTextOfFieldApuesta(Form<CompetirAppModel> form) {
		form.add(new TextField<String>("apuestaRealizada"));
		form.add(new FeedbackPanel("feedbackPanel"));
	}
	
	protected void backToPage(){
		this.setResponsePage(mainPage);
	}
	
	protected void createButton(Form<CompetirAppModel> compraForm) {
		compraForm.add(new Button("Competir"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				CompetirPage.this.battleground.competirPorHonor();
				CompetirPage.this.backToPage();
			}
		});
		compraForm.add(new Button("Cancelar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				CompetirPage.this.battleground.rechazarReto();
				CompetirPage.this.backToPage();
			}
		});
	}
	
	protected void createTableRobotsPreparedToFight(Form<CompetirAppModel> competirForm){
		RadioGroup<Robot> group =new RadioGroup<Robot>("contrincanteSeleccionado");
		competirForm.add(group);

		@SuppressWarnings("serial")
		ListView<Robot> robotsPreparedToFight =new ListView<Robot>("robotsPreparedToFight", this.robotsPreparedToFight) { 
		    protected void populateItem(ListItem<Robot> item) {
		      item.add(new Radio<Robot>("robot", item.getModel()));
		      item.add(new Label("nombrePropietario", new PropertyModel<Robot>(item.getModel(), "nombrePropietario")));
		      item.add(new Label("nombreRobot", new PropertyModel<Robot>(item.getModel(), "nombreRobot")));
		      item.add(new Label("poder",new PropertyModel<Robot>(item.getModel(), "poder")));
		    }
		   };
		group.add(robotsPreparedToFight);
	}
}

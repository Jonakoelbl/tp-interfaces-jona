package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;

import robots.appModel.IndexJugador;
import robots.appModel.MejoraAppModel;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;

public class MejoraPage extends WebPage{
	private static final long serialVersionUID = 1l;
	
	private final IndexPage mainPage;
	private final MejoraAppModel tiendaDeMejora ;
	
	public MejoraPage(IndexJugador dataBase,Robot robotAMejorar,IndexPage mainPage) {
		this.mainPage = mainPage;
		this.tiendaDeMejora = new MejoraAppModel(dataBase.getJugador(),robotAMejorar, dataBase.getTienda());
		Form<MejoraAppModel> mejoraForm = new Form("mejorarRobotForm",new CompoundPropertyModel<MejoraAppModel>(this.tiendaDeMejora));
		this.createFieldOfText(mejoraForm);
		this.createTableMejora(mejoraForm);
	}

	protected void createTableMejora(Form<MejoraAppModel> mejoraForm) {
		mejoraForm.add(new PropertyListView<Mejora>("mejorasEnVenta") {

			@Override
			protected void populateItem(ListItem<Mejora> mej) {
				mej.add(new Label("descripcion"));
				mej.add(new Label("mejoraDePoder"));
				mej.add(new Label("precio"));
			}			
		});
	}

	protected void createFieldOfText(Form<MejoraAppModel> mejoraForm) {
		mejoraForm.add(new Label("poder"));
	}
}

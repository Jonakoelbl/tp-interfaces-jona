package robot.ui.wicket;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import robots.appModel.IndexJugador;
import robots.appModel.MejoraAppModel;

import DominioRobot.Mejora;
import DominioRobot.Robot;

public class MejoraPage extends WebPage{
	private static final long serialVersionUID = 1L;
	
	private final IndexPage mainPage;
	private final MejoraAppModel tiendaDeMejora ;
	
	public MejoraPage(IndexJugador dataBase,Robot robotAMejorar,IndexPage mainPage) {
		this.mainPage = mainPage;
		this.tiendaDeMejora = new MejoraAppModel(dataBase.getJugador(),robotAMejorar, dataBase.getTienda());
		Form<MejoraAppModel> mejoraForm = new Form<MejoraAppModel>("mejoraForm",new CompoundPropertyModel<MejoraAppModel>(this.tiendaDeMejora));
		this.createTableUpgradeRobot(mejoraForm);
		this.createTableMejora(mejoraForm);
		this.createFieldOfText(mejoraForm);
		this.createButton(mejoraForm);
		this.add(mejoraForm);
	}
	
	private void createTableUpgradeRobot(Form<MejoraAppModel> parent) {
		parent.add(new PropertyListView<Mejora>("robotAMejorar.actualizaciones") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Mejora> item) {
				item.add(new Label("descripcion"));
				item.add(new Label("mejoraDePoder"));
			}
		});
	}

	private void createButton(Form<MejoraAppModel> mejoraForm) {
		mejoraForm.add(new Button("Aceptar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				MejoraPage.this.tiendaDeMejora.mejorar();
				MejoraPage.this.backMainPage();
			}
		});
		
		mejoraForm.add(new Button("Cancelar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				MejoraPage.this.backMainPage();
			}
		});
	}

	protected void createTableMejora(Form<MejoraAppModel> mejoraForm) {
		RadioGroup<Mejora> group =new RadioGroup<Mejora>("mejoraSeleccionado");
		mejoraForm.add(group);


		ListView<Mejora> mejoras=new ListView<Mejora>("mejorasEnVenta", this.tiendaDeMejora.getMejorasEnVenta()) {

			private static final long serialVersionUID = 1L;
		    protected void populateItem(ListItem<Mejora> item) {
		      item.add(new Radio<Mejora>("mejora", item.getModel()));
		      item.add(new Label("descripcion", new PropertyModel<Mejora>(item.getModel(), "descripcion")));
		      item.add(new Label("mejoraDePoder", new PropertyModel<Mejora>(item.getModel(), "mejoraDePoder")));
		      item.add(new Label("precio", new PropertyModel<Mejora>(item.getModel(), "precio")));
		    }
		   };
		group.add(mejoras);
	}
	
	protected void backMainPage(){
		this.setResponsePage(mainPage);
	}
	
	protected void createFieldOfText(Form<MejoraAppModel> mejoraForm) {
		mejoraForm.add(new Label("robotAMejorar.poder"));
	}
}

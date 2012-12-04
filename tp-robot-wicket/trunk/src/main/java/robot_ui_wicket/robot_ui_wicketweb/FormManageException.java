package robot_ui_wicket.robot_ui_wicketweb;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.model.IModel;
import org.uqbar.commons.model.UserException;

public class FormManageException<T> extends Form<T> {
	private static final long serialVersionUID = 7709352038539637936L;

	public FormManageException(String id, IModel<T> model) {
		super(id, model);
	}

	@Override
	public void process(IFormSubmitter submittingComponent) {
		try {
			super.process(submittingComponent);
		} catch (RuntimeException e) {
			if (e instanceof UserException) {
				this.error(e.getMessage());
			} else {
				throw e;
			}
		}
	}
}

package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "vPass")
public class ValidadorPwd implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		UIInput pwd=(UIInput)arg1.findComponent("pwd");
		String pass=(String)pwd.getValue();
		String pass2=(String)arg2;
		if(!pass.equals(pass2)) {
			throw new ValidatorException(new FacesMessage("Contraseñas no coinciden"));
		}
	}

}

package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "convertTel")
public class ConversorTelefono implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2==null||arg2.equals("")) {
			return 10000;
		}else {
			return Integer.parseInt(arg2);
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Integer valor=(Integer)arg2;
		if(valor==0) {
			return "";
		}else {
			return valor.toString();
		}
	}

}

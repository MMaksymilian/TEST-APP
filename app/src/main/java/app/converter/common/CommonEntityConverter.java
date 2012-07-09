package app.converter.common;

import core.orm.dao.BaseDAO;
import core.orm.entities.core.BaseEntity;
import org.springframework.util.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 09.07.12
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class CommonEntityConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            String[] valueArray = value.split(":");
            Long id = Long.valueOf(valueArray[0]);
            BaseDAO dao = (BaseDAO) context.
                    getELContext().getELResolver().getValue(context.getELContext(), null, StringUtils.uncapitalize(valueArray[1]) + "DAOImpl");
            return dao.getById(id);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Converter - conversion error message:" + e.getMessage(), "Invalid format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg, e);
        }
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            return ((BaseEntity) value).getId().toString() + ":" + value.getClass().getSimpleName();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Converter - conversion error message: ", "Invalid format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(e);
        }
    }
}

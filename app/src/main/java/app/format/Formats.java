package app.format;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 11.07.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ApplicationScoped
public class Formats {
    private String dateFormat = "MM/dd/yyyy";

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}

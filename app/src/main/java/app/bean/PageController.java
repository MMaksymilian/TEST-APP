
package app.bean;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 12.07.12
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
    private String chosenMenuItemId;

    public void chooseMenuItem(ActionEvent event) {
        chosenMenuItemId = event.getComponent().getClientId();
    }

    public String getChosenMenuItemId() {
        return chosenMenuItemId;
    }

    public void setChosenMenuItemId(String chosenMenuItemId) {
        this.chosenMenuItemId = chosenMenuItemId;
    }
}


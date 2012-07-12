
package app.bean;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 12.07.12
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean
public class PageController {
    private String chosenId;

    public void chooseMenuItem(ActionEvent event) {
        chosenId = event.getComponent().getId();
    }

    public String getChosenId() {
        return chosenId;
    }

    public void setChosenId(String chosenId) {
        this.chosenId = chosenId;
    }
}


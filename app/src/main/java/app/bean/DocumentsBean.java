package app.bean;

import app.bean.session.PageController;
import app.bean.session.UserSessionBean;
import app.services.DeclarationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 19.07.12
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class DocumentsBean implements Serializable {

    @ManagedProperty("#{declarationService}")
    private DeclarationService declarationService;

    @ManagedProperty("#{userSessionBean}")
    private UserSessionBean userSessionBean;

    public String saveDeclaration() {
        declarationService.saveDeclaration(userSessionBean.getUserDeclaration());
        UserSessionBean newUserSessionBean = new UserSessionBean();
        newUserSessionBean.initMethod();
        PageController newPageController = new PageController();
        newPageController.initMethod();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSessionBean", newUserSessionBean);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pageController", newPageController);
        return "summary";
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}

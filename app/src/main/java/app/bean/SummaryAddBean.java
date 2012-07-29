package app.bean;

import app.bean.session.UserSessionBean;
import app.bean.session.goaltick.GoalTick;
import core.orm.entities.Declaration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 23.07.12
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class SummaryAddBean implements Serializable {

    @ManagedProperty("#{pageController.summary}")
    private GoalTick goalTick;

    @ManagedProperty("#{userSessionBean}")
    UserSessionBean userSessionBean;

    public String startOverWithExistingDeclaration(Declaration declaration) {
        userSessionBean.setCreditAmount(declaration.getCreditAmount());
        userSessionBean.setInterest(declaration.getInterest());
        userSessionBean.setTotalDecalarations(declaration.getEstateValue());
        userSessionBean.setUserDeclaration(declaration);
        return "productType";
    }

    /*GETTERy i SETTERy*/
    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}

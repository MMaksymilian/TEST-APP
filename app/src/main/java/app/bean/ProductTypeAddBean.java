package app.bean;

import app.bean.session.PageController;
import app.bean.session.goaltick.GoalTick;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 23.07.12
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class ProductTypeAddBean implements Serializable {

    @ManagedProperty("#{pageController.productType}")
    private GoalTick goalTick;

    public void fakeTick() {
        goalTick.setCompleted(true);
    }

    /*GETTERy i SETTERy*/
    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }
}

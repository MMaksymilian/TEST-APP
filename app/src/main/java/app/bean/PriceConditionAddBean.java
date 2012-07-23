package app.bean;

import app.bean.session.goaltick.GoalTick;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 23.07.12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class PriceConditionAddBean implements Serializable {

    @ManagedProperty("#{pageController.priceCondition}")
    private GoalTick goalTick;


    public void fakeTick() {
        goalTick.setCompleted(true);
    }

    /*GETTERy i SETTERy*/
    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }
}

package app.bean;

import app.bean.session.UserSessionBean;
import app.bean.session.goaltick.GoalTick;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 23.07.12
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class InterestAddBean implements Serializable {

    @ManagedProperty("#{pageController.interest}")
    private GoalTick goalTick;

    private Double interest;

    @ManagedProperty("#{userSessionBean}")
    private UserSessionBean userSessionBean;

    /*fajnie by bylo ale nie dalo sie*/
//    @ManagedProperty("#{userSessionBean.interest}")
//    private Double interest;

    public void initMethod() {
       interest = userSessionBean.getInterest();
    }

    public void fakeTick() {
        goalTick.setCompleted(true);
    }

    /*GETTERy i SETTERy*/
    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) throws GoalTick.GoalDoesNotExistException {
        this.interest = interest;
        userSessionBean.setInterest(interest);
        goalTick.tickGoal("oprocentowanie_kredytu");
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}

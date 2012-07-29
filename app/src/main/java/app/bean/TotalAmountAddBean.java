package app.bean;

import app.bean.session.UserSessionBean;
import app.bean.session.goaltick.GoalTick;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Digits;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 23.07.12
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class TotalAmountAddBean implements Serializable {

    @ManagedProperty("#{pageController.totalAmount}")
    private GoalTick goalTick;

    @ManagedProperty("#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @Digits(integer = 10, fraction = 2)
    private Double creditAmount;


    @PostConstruct
    public void initMethod() {
       creditAmount = userSessionBean.getCreditAmount();
    }

    /*To nie jest zwykly setter!*/
    public void setCreditAmount(Double creditAmount) throws GoalTick.GoalDoesNotExistException {
        this.creditAmount = creditAmount;
        userSessionBean.setCreditAmount(creditAmount);
        goalTick.tickGoal("wnioskowana_kwota_kredytu");
    }

    /*GETTERy i SETTERy*/
    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}

package app.controllers.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class UserSession {

    private Double totalDecalarations = 3000d;

    private Double credit = 100d;

    private Double interest = 15d;

    public Double getTotalDecalarations() {
        return totalDecalarations;
    }

    public void setTotalDecalarations(Double totalDecalarations) {
        this.totalDecalarations = totalDecalarations;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }
}

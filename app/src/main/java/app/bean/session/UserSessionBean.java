package app.bean.session;

import core.orm.entities.Declaration;
import core.orm.entities.DeclarationRecord;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class UserSessionBean implements Serializable {

    private Declaration userDeclaration;

    /* Informacje wyświetlane na dole w "Informacje o sesji użytkownika*/
    private Double totalDecalarations;

    @Digits(integer = 10, fraction = 2)
    private Double creditAmount;

    private Double interest;
    /* Informacje wyświetlane na dole w "Informacje o sesji użytkownika*/

    public UserSessionBean() {
        if(userDeclaration == null) {
            userDeclaration = new Declaration();
            userDeclaration.setDeclarationRecords(new HashSet<DeclarationRecord>());
        }
    }

    @PostConstruct
    public void initMethod() {
    }

    public Double getTotalDecalarations() {
        return totalDecalarations;
    }

    public void setTotalDecalarations(Double totalDecalarations) {
        this.totalDecalarations = totalDecalarations;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    /**
     * Ustawia jeszcze w obiekcie deklaracji sesji użytkownika wartość wnioskowanej kwoty kredytu
     * @param creditAmount
     */
    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
        userDeclaration.setCreditAmount(creditAmount);
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Declaration getUserDeclaration() {
        return userDeclaration;
    }

    public void setUserDeclaration(Declaration userDeclaration) {
        this.userDeclaration = userDeclaration;
    }
}

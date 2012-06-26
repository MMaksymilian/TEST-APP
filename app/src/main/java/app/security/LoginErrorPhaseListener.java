package app.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LoginErrorPhaseListener implements PhaseListener
{
    private static final long serialVersionUID = -1216620620302322995L;


    public void beforePhase(final PhaseEvent arg0)
    {
        Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
                WebAttributes.AUTHENTICATION_EXCEPTION);

        if (e instanceof BadCredentialsException)
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędna nazwa użytkownika lub hasło"));
        }
    }

    public void afterPhase(final PhaseEvent arg0) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

}
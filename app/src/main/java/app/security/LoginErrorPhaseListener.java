package app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LoginErrorPhaseListener implements PhaseListener {
    private static final long serialVersionUID = -1216620620302322995L;
    public static final Logger log = LoggerFactory.getLogger(RequestLogger.class);

    public void beforePhase(PhaseEvent event) {

        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {

            log.info("*PhaseTracker1: Before Phase: " + event.getPhaseId() + ". <--- +" +
                    event.getFacesContext().getExternalContext().getRequestServletPath());
        } else {
            log.info("*PhaseTracker1: Before Phase: " + event.getPhaseId());
        }
    }

    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            log.info("*PhaseTracker1: After Phase: " + event.getPhaseId() + "--->" +
                    event.getFacesContext().getViewRoot().getViewId());
            log.info("-------------------------------------------------------------");
        } else {
            log.info("*PhaseTracker1: After Phase: " + event.getPhaseId());
        }
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
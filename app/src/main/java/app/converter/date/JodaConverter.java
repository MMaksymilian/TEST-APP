package app.converter.date;

import org.joda.time.DateTimeZone;

import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.Locale;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Converter for JodaTime classes
 * Does not attempt to copy the JSF DateConverter by handling date/time type and short/medium/etc styles.
 * Copyright Zac Parkplatz Ltd 2007
 *
 * @author jon@parkplatz.net
 * @version 13-Jun-2007
 */
public abstract class JodaConverter implements Converter, StateHolder {
    
    private Locale locale;
    private String pattern;
    private DateTimeZone timeZone;
    private boolean amTransient;
    
    public abstract Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value);
    
    public abstract String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value);
    
    protected abstract DateTimeFormatter getDateFormat();
    
    public void restoreState(FacesContext facesContext, Object state) {
        Object[] values = (Object[]) state;
        locale = (Locale) values[0];
        timeZone = (DateTimeZone) values[1];
        pattern = (String) values[2];
    }
    
    public Object saveState(FacesContext facesContext) {
        Object[] values = new Object[3];
        values[0] = locale;
        values[1] = timeZone;
        values[2] = pattern;
        return values;
    }
    
    public Locale getLocale() {
        if (locale != null)
            return locale;
        
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getViewRoot().getLocale();
    }
    
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public String getPattern() {
        return pattern;
    }
    
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public DateTimeZone getTimeZone() {
        return timeZone;
    }
    
    public void setTimeZone(DateTimeZone timeZone) {
        this.timeZone = timeZone;
    }
    
    public boolean isTransient() {
        return amTransient;
    }
    
    public void setTransient(boolean amTransient) {
        this.amTransient = amTransient;
    }
    
}

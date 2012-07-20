package app.converter.date;

import javax.faces.application.FacesMessage;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.joda.time.format.ISODateTimeFormat;

/**
 * Converter for JodaTime DateTime class
 * Copyright Zac Parkplatz Ltd 2007
 *
 * @author jon@parkplatz.net
 * @version 05-Jul-2007
 */
@FacesConverter(forClass = DateTime.class)
public class DateTimeConverter extends JodaConverter {

    public static final String CONVERTER_ID = "org.joda.ext.jsf.converter.DateTime";

    public static final String BAD_DATE_SUMMARY = "badDate";
    public static final String BAD_DATE_DETAIL = "badDateDetail";

    public DateTimeConverter() {
        setPattern("MM/dd/yyyy");
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (facesContext == null) {
            throw new NullPointerException("facesContext");
        }
        if (uiComponent == null) {
            throw new NullPointerException("uiComponent");
        }

        if (value != null) {
            value = value.trim();
            if (value.length() > 0) {
                DateTimeFormatter format = getDateFormat();

                try {
                    return format.parseDateTime(value);
                } catch (IllegalArgumentException e) {
                    FacesMessage errorMessage = new FacesMessage("Wrong date format. app.converter.date.DateTimeConverter converter error. Required format: ",
                            "Wrong date format. app.converter.date.DateTimeConverter converter error. Required format: ");
                    throw new ConverterException(errorMessage);
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (facesContext == null) {
            throw new NullPointerException("facesContext");
        }
        if (uiComponent == null) {
            throw new NullPointerException("uiComponent");
        }

        if (value == null) {
            return "";
        }
        if (value instanceof String) {
            return (String) value;
        }

        DateTimeFormatter format = getDateFormat();

        try {
            return format.print((ReadableInstant) value);
        } catch (Exception e) {
            throw new ConverterException("Cannot convert value '" + value + "'");
        }
    }

    protected DateTimeFormatter getDateFormat() {
        DateTimeFormatter formatr = null;

        String pattern = getPattern();
        if (pattern == null)
            formatr = ISODateTimeFormat.dateTime();
        else
            formatr = DateTimeFormat.forPattern(pattern);

        formatr = formatr.withLocale(getLocale());
        formatr = formatr.withZone(getTimeZone());

        return formatr;
    }

}

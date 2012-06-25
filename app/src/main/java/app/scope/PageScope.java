package app.scope;

import org.springframework.beans.factory.ObjectFactory;

import javax.faces.context.FacesContext;
import java.util.Map;


public class PageScope implements org.springframework.beans.factory.config.Scope{
    public Object get(String s, ObjectFactory<?> objectFactory) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> map = context.getViewRoot().getViewMap(true);
        if(!map.containsKey(s))
            map.put(s, objectFactory.getObject());
        return map.get(s);
    }

    public Object remove(String s) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> map = context.getViewRoot().getViewMap(true);
        return map.remove(s);
    }

    public void registerDestructionCallback(String s, Runnable runnable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object resolveContextualObject(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getConversationId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
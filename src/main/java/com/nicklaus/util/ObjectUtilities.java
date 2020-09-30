package com.nicklaus.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Map;

public class ObjectUtilities {

    public static Object getSessionAttribute(String name){

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Map<String, Object> map = externalContext.getSessionMap();

        return map.get(name);
    }
}

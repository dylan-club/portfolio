package com.nicklaus.bean;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class PageBean {

    private String imgURI;

    private Map<String,String> colorMap;

    public PageBean(){}

    public String getImgURI() {
        int img = 1+(int)(Math.random()*3);
        imgURI = "resources/images/"+img+".jpg";
        return imgURI;
    }

    public Map<String, String> getColorMap() {
        return colorMap;
    }

    public void setColorMap(Map<String, String> colorMap) {
        this.colorMap = colorMap;
    }

    public String quit(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.removeAttribute("userManager");
        return "index";
    }
}

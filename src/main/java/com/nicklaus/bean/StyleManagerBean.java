package com.nicklaus.bean;

import com.nicklaus.service.StyleService;
import com.nicklaus.service.impl.StyleServiceImpl;
import com.nicklaus.util.ObjectUtilities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "styleManager")
@SessionScoped
public class StyleManagerBean implements Serializable {

    private StyleBean userStyle;

    private StyleService service = new StyleServiceImpl();

    public StyleManagerBean(){}

    public StyleBean getUserStyle() {
        UserManagerBean userManger = (UserManagerBean)ObjectUtilities.getSessionAttribute("userManager");
        UserBean user = userManger.getLoginUser();
        if (user != null){
            userStyle = service.findByUid(user.getUid());
            if (userStyle == null){
                service.createByUid(user.getUid());
                userStyle = service.findByUid(user.getUid());
            }

        }

        return userStyle;
    }

    public String updateStyle(){
        UserManagerBean userManger = (UserManagerBean)ObjectUtilities.getSessionAttribute("userManager");
        UserBean user = userManger.getLoginUser();
        if (user != null){
            service.update(userStyle);
        }
        return "home";
    }

    public void setUserStyle(StyleBean userStyle) {
        this.userStyle = userStyle;
    }

}

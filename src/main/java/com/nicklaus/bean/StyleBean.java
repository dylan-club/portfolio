package com.nicklaus.bean;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "style_table")
public class StyleBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int sid;

    @Column(name = "u_id")
    private int uid;

    @Column(name = "s_bgColorRGB")
    private String bgColor;


    public StyleBean(){}

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}

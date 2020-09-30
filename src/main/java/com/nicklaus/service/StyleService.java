package com.nicklaus.service;

import com.nicklaus.bean.StyleBean;

public interface StyleService {

    /**
     * update user style
     * @param styleBean
     */
    public void update(StyleBean styleBean);

    /**
     * find style by user id
     * @param uid
     * @return
     */
    public StyleBean findByUid(int uid);

    /**
     * create a style with user id
     * @param uid
     */
    public void createByUid(int uid);
}

package com.nicklaus.dao;

import com.nicklaus.bean.StyleBean;

public interface StyleDAO {

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

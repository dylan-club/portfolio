package com.nicklaus.service.impl;

import com.nicklaus.bean.StyleBean;
import com.nicklaus.dao.StyleDAO;
import com.nicklaus.dao.impl.StyleDAOImpl;
import com.nicklaus.service.StyleService;

public class StyleServiceImpl implements StyleService {

    private StyleDAO dao = new StyleDAOImpl();

    @Override
    public void update(StyleBean styleBean) {
        dao.update(styleBean);
    }

    @Override
    public StyleBean findByUid(int uid) {
        return dao.findByUid(uid);
    }

    @Override
    public void createByUid(int uid) {
        dao.createByUid(uid);
    }
}

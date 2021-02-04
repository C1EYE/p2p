package com.xmg.p2p.base.service.impl;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.mapper.LogininfoMapper;
import com.xmg.p2p.base.service.LogininfoService;
import com.xmg.p2p.base.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogininfoServiceImpl implements LogininfoService {

    @Autowired
    private LogininfoMapper loginfoMapper;

    @Override
    public void register(String username, String password) {
        //判断用户名是否存在
        int count = loginfoMapper.getCountByUsername(username);
        //不存在保存
        if (count<=0){
            Logininfo logininfo = new Logininfo();
            logininfo.setUsername(username);
            logininfo.setPassword(MD5.encode(password));
            logininfo.setState(Logininfo.STATE_NORMAL);
        }else {
            throw new RuntimeException("用户名已存在!");
        }
        //如果存在抛出
    }
}

package com.zhou.oauth2.server.service.impl;

import com.zhou.oauth2.server.dao.TbUserMapper;
import com.zhou.oauth2.server.pojo.TbUser;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service(value = "tbUserServiceImpl")
public class TbUserServiceImpl {
    @Resource
    private TbUserMapper tbUserMapper;


    public TbUser getByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", username);
        return tbUserMapper.selectOneByExample(example);
    }
}

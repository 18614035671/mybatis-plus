package com.disp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.disp.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author xuzl
 * @email xzl18614035671@gmail.com
 * @date 2019-05-30 15:15:45
 */
public interface UserService extends IService<UserEntity> {

    List<UserEntity> getUser();

    void insertUser();

    void updateUser(Long id);

    void delAllUser(String[] ids);

    void deleteUser(Long id);
}


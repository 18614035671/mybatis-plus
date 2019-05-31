package com.disp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.disp.entity.UserEntity;

import java.util.List;

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

    IPage<UserEntity> getUserPage(Integer currentPage, Integer pageSize);
}


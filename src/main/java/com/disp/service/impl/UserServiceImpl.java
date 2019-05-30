package com.disp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.disp.dao.UserDao;
import com.disp.entity.UserEntity;
import com.disp.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserEntity> getUser() {
        return this.list(new QueryWrapper<UserEntity>());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void insertUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("55555");
        userEntity.setPassword("123456");
        userEntity.setDeptId(415L);
        userEntity.setEmail("asd");
        userEntity.setMobile("das");
        userEntity.setStatus("1");
        userEntity.setCrateTime(new Date());
        userEntity.setModifyTime(new Date());
        userEntity.setLastLoginTime(new Date());
        userEntity.setSsex("1");
        userEntity.setTheme("2");
        userEntity.setAvatar("2");
        userEntity.setDescription("3");
        userDao.insert(userEntity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateUser(Long id) {
        /*int mmp = userDao.update(
                new UserEntity().setUserId(id),
                Wrappers.<UserEntity>lambdaUpdate()
                        .set(UserEntity::getUsername, "mmp")
                        .eq(UserEntity::getUserId, 2)
        );*/
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setEmail("9999999999999999999@123.com");
        userDao.updateById(userEntity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void delAllUser(String[] ids) {
        userDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}

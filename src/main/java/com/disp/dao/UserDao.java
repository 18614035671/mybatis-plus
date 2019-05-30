package com.disp.dao;

import com.disp.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 * 
 * @author xuzl
 * @email xzl18614035671@gmail.com
 * @date 2019-05-30 15:15:45
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {
	
}

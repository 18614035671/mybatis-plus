package com.disp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.disp.entity.UserEntity;

import java.util.List;

/**
 * 用户表
 *
 * @author xuzl
 * @email 18614035671@163.com
 * @date 2019-05-30 15:15:45
 */
public interface UserService extends IService<UserEntity> {

    /**  
     * 查询
     *
     * @param 
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    List<UserEntity> getUser();

    /**  
     * 添加
     *
     * @param 
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    void insertUser();

    /**  
     * 修改
     *
     * @param id
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    void updateUser(Long id);

    /**  
     * 多个删除
     *
     * @param ids
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    void delAllUser(String[] ids);

    /**  
     * 删除
     *
     * @param id
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    void deleteUser(Long id);

    /**  
     * 分页查询
     *
     * @param currentPage 
     * @param pageSize
     * @return 
     * @Author: xuzl
     * @Date: 2019年06月03日
     **/
    IPage<UserEntity> getUserPage(Integer currentPage, Integer pageSize);
}


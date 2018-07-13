package com.ln.demo.dao;


import com.ln.demo.entity.Role;

import java.util.List;

/**
 * 用户角色dao接口
 * 
 * @author hulichao
 * @date 2018/4/9
 */
public interface UserRoleDAO {
    
    /**
     * 根据用户id得到角色列表
     * @param userId
     * @return
     */
    List<Role> listUserRole(int userId);
    
    /**
     * 添加用户角色
     * @param userId
     * @param roleIds
     * @return
     */
    int saveUserRole(int userId, int[] roleIds);
    
    /**
     * 根据用户id删除用户角色
     * @param userId
     * @return
     */
    int removeByUserId(int userId);
    
    /**
     * 根据角色id删除用户角色
     * @param roleId
     * @return
     */
    int removeByRoleId(int roleId);

}

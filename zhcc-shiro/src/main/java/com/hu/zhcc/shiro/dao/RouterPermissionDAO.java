package com.hu.zhcc.shiro.dao;


import com.hu.zhcc.shiro.entity.bo.Router;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 路由权限DAO接口
 * 
 * @author hulichao
 * @date 2018/3/22
 */
@MapperScan
public interface RouterPermissionDAO {

    /**
     * 根据用户id得到路由权限列表
     * @param userId
     * @return
     */
    List<Router> listByUserId(int userId);
    
    /**
     * 根据角色id删除路由权限
     * @param roleId
     */
    void removeByRoleId(int roleId);
    
    /**
     * 保存路由权限
     * @param roleId
     * @param routerIds
     * @return
     */
    int savePermission(int roleId, int[] routerIds);
    
}

package com.hu.demo.dao;

import com.hu.demo.entity.Role;
import com.hu.demo.common.data.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 角色DAO接口
 * 
 * @author hulichao
 * @date 2018/3/27
 */
public interface RoleDAO {

    /**
     * 统计角色数
     * 
     * @param parameters
     *            查询条件
     * @return
     */
    int countRole(Map<String, Object> parameters);

    /**
     * 分页查询角色信息
     * 
     * @param pageRequest
     *            分页请求参数
     * @return
     */
    List<Role> listRole(PageRequest pageRequest);
    
    /**
     * 添加角色
     * @param role
     */
    void saveRole(Role role);
    
    /**
     * 根据id得到角色
     * @param id
     * @return
     */
    Role getById(int id);
    
    /**
     * 更新角色
     * @param role
     * @return
     */
    int updateRole(Role role);
    
    /**
     * 删除角色
     * @param id
     * @return
     */
    int removeRole(int id);
    
    /**
     * 得到所有角色
     * @return
     */
    List<Role> listAllRole();

}

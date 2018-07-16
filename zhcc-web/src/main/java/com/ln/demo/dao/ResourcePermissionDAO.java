package com.ln.demo.dao;


import com.ln.demo.entity.Resource;

import java.util.List;

/**
 * 权限管理DAO接口
 * 
 * @author hulichao
 * @date 2018/3/30
 */
public interface ResourcePermissionDAO {

	/**
	 * 根据用户id得到资源权限
	 * 
	 * @param userId
	 *            用户Id
	 * @return
	 */
	List<Resource> listByUserId(int userId);
	
	/**
	 * 根据路由id得到资源权限
	 * @param userId
	 * @param routerId
	 * @return
	 */
	List<Resource> listPermission(int userId, int routerId);
	
	/**
	 * 根据用户id得到资源权限代码
	 * @param userId
	 * @return
	 */
	List<String> listCodeByUserId(int userId);
	
	/**
	 * 根据角色id删除资源权限
	 * @param roleId
	 * @return
	 */
	int removeByRoleId(int roleId);
	
	/**
	 * 根据角色id得到资源权限
	 * @param roleId
	 * @return
	 */
	List<Integer> listByRoleId(int roleId);
	
	/**
	 * 保存权限
	 * @param roleId
	 * @param resourceIds
	 * @return
	 */
	int savePermission(int roleId, int[] resourceIds);

}

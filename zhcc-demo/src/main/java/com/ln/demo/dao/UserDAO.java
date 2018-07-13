package com.ln.demo.dao;

import com.ln.demo.entity.User;
import com.ln.demo.common.data.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 用户管理dao接口
 * 
 * @author hulichao
 * @date 2018/3/2
 */
public interface UserDAO {

	/**
	 * 根据登录名得到用户
	 * 
	 * @param loginName
	 *            登录名
	 * @return
	 */
	User getByLoginName(String loginName);

	/**
	 * 创建系统用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 修改用户口令
	 * 
	 * @param userId
	 *            用户Id
	 * @param salt
	 *            盐
	 * @param password
	 *            口令
	 * @return
	 */
	int updatePassword(int userId, String salt, String password);

	/**
	 * 统计用户数
	 * 
	 * @param condition
	 *            查询条件
	 * @return
	 */
	int countUser(Map<String, Object> parameters);

	/**
	 * 分页查询用户信息
	 * 
	 * @param pageRequest
	 *            分页请求参数
	 * @return
	 */
	List<User> listUser(PageRequest pageRequest);
	
	/**
	 * 根据用户Id查询用户信息
	 * @param id 用户id
	 * @return
	 */
	User getById(int id);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @param deletedAt 删除时间
	 * @return
	 */
	int removeUser(int id, long deletedAt);

}

package com.hu.demo.service;

import com.hu.demo.dao.ResourcePermissionDAO;
import com.hu.demo.dao.RoleDAO;
import com.hu.demo.dao.RouterPermissionDAO;
import com.hu.demo.dao.UserRoleDAO;
import com.hu.demo.dto.RoleDTO;
import com.hu.demo.entity.Role;
import com.hu.demo.common.data.Page;
import com.hu.demo.common.data.PageRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色服务实现类
 * 
 * @author hulichao
 * @date 2018/3/27
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Autowired
	private ResourcePermissionDAO resourcePermissionDAO;
	
	@Autowired
	private RouterPermissionDAO routerPermissionDAO;

    /**
     * 得到角色列表
     * @param parameters
     * @param offset
     * @param limit
     * @return
     */
	@Override
    public Page<RoleDTO> listRole(Map<String, Object> parameters, int offset, int limit) {
        int total = this.roleDAO.countRole(parameters);
        List<RoleDTO> dtoList = null;
        if(total > 0) {
            PageRequest pageRequest = new PageRequest(offset, limit, parameters, null);
            List<Role> list = this.roleDAO.listRole(pageRequest);
            dtoList = new ArrayList<RoleDTO>(list.size());
            for(Role role : list) {
                RoleDTO dto = new RoleDTO();
                BeanUtils.copyProperties(role, dto);
                dtoList.add(dto);
            }
        }
        return new Page<RoleDTO>(total, dtoList);
    }
    
	/**
	 * 添加角色
	 * @param dto
	 * @return
	 */
    @Override
    @Transactional
    public RoleDTO saveRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        this.roleDAO.saveRole(role);
        dto.setId(role.getId());
        return dto;
    }
    
    /**
     * 根据id得到角色
     * @param id
     * @return
     */
    @Override
    public RoleDTO getById(int id) {
        Role role = this.roleDAO.getById(id);
        if(role == null) {
            return null;
        }
        RoleDTO dto = new RoleDTO();
        BeanUtils.copyProperties(role, dto);
        return dto;
    }
    
    /**
     * 更新角色
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public int updateRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return this.roleDAO.updateRole(role);
    }
    
    /**
     * 得到所有角色
     * @return
     */
    @Override
    public List<RoleDTO> listAllRole() {
        List<Role> list = this.roleDAO.listAllRole();
        List<RoleDTO> dtoList = new ArrayList<RoleDTO>(list.size());
        for(Role role : list) {
            RoleDTO dto = new RoleDTO();
            BeanUtils.copyProperties(role, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    /**
     * 删除角色
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int removeRole(int id) {
        int rows = this.roleDAO.removeRole(id);
        this.userRoleDAO.removeByRoleId(id);
        this.resourcePermissionDAO.removeByRoleId(id);
        this.routerPermissionDAO.removeByRoleId(id);
        return rows;
    }
    
    /**
     * 得到资源权限列表
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> listResourcePermission(int roleId) {
        return this.resourcePermissionDAO.listByRoleId(roleId);
    }

    /**
     * 保存角色权限
     * @param roleId
     * @param routerIds
     * @param resourceIds
     * @return
     */
    @Override
    @Transactional
    public int savePermission(int roleId, int[] routerIds, int[] resourceIds) {
        // 先删除后添加
        this.routerPermissionDAO.removeByRoleId(roleId);
        this.resourcePermissionDAO.removeByRoleId(roleId);
        
        int rows = 0;
        rows += this.routerPermissionDAO.savePermission(roleId, routerIds);
        rows += this.resourcePermissionDAO.savePermission(roleId, resourceIds);
        return rows;
    }
    
}

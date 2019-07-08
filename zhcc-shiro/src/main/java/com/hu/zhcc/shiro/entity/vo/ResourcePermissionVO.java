package com.hu.zhcc.shiro.entity.vo;

/**
 * 资源权限vo类
 * 
 * @author hulichao
 * @date 2018/4/26
 */
public final class ResourcePermissionVO {
    
    private int roleId;
    
    private int resourceId;
    
    private String resourcePermission;
    
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public int getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    
    public String getResourcePermission() {
        return this.resourcePermission;
    }

    public void setResourcePermission(String resourcePermission) {
        this.resourcePermission = resourcePermission;
    }

}

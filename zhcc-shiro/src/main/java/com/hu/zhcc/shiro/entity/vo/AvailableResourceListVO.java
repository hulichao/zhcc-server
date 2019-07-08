package com.hu.zhcc.shiro.entity.vo;

/**
 * 可用资源列表vo类
 * 
 * @author hulichao
 * @date 2018/4/27
 */
public final class AvailableResourceListVO {

    private int id;
    
    private String name;
    
    private int routerId;
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getRouterId() {
        return this.routerId;
    }

    public void setRouterId(int routerId) {
        this.routerId = routerId;
    }
    
}

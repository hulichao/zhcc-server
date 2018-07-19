package com.hu.demo.service;


import com.hu.demo.dto.RouterDTO;
import com.hu.demo.common.data.Page;

import java.util.List;
import java.util.Map;

/**
 * 路由服务接口
 * 
 * @author hulichao
 * @date 2018/3/19
 */
public interface RouterService {


    /**
     * 得到路由列表
     * @param parameters
     * @param offset
     * @param limit
     * @return
     */
    Page<RouterDTO> listRouter(Map<String, Object> parameters, int offset, int limit);

    /**
     * 得到已授权的路由
     * 
     * @param userId
     *            用户id
     * @return
     */
    List<RouterDTO> listAuthorizedRouter(int userId);
    
    /**
     * 根据路由id得到路由信息
     * @param id
     * @return
     */
    RouterDTO getById(int id);
    
    /**
     * 根据上级路由id得到路由列表
     * @param parentId
     * @return
     */
    List<RouterDTO> listByParentId(int parentId);
    
    /**
     * 更新路由
     * @param routerDto
     * @return
     */
    int updateRouter(RouterDTO routerDto);
    
    /**
     * 添加路由
     * @param dto
     * @return
     */
    RouterDTO saveRouter(RouterDTO dto);
    
    /**
     * 删除路由
     * @param id
     * @return
     */
    int removeRouter(int id);
    
    /**
     * 得到所有路由
     * @param includeLocked 包括状态为已禁用的
     * @return
     */
    List<RouterDTO> listAll(boolean includeLocked);

}

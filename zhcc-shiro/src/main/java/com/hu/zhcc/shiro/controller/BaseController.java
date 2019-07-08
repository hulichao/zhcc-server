package com.hu.zhcc.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.hu.zhcc.shiro.utils.JwtUtils;
import io.jsonwebtoken.Claims;

/**
 * Controllerg公用基类
 * 包含全局异常和jwt--> subject
 * 处理全局异常两种方式
 * 		1.如本类中，继承一个Controller(已注释)
 * 	    2.使用全局异常bean来处理
 *
 *
 * @author hulichao
 * @date 2018/3/15
 */
public class BaseController {

/*    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(HttpServletRequest request, Exception e) {
    	//FIXME
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("系统管理员跑路拉，您再自己瞅瞅吧");
    }*/
	
	/**
	 * 从jwt中获取subject信息
	 * @param jwtUtils
	 * @param jwt
	 * @param key
	 * @return
	 */
	protected String getSubjectFromJwt(JwtUtils jwtUtils, String jwt, String key) {
		Claims claims = jwtUtils.parseJWT(jwt);
		String subject = claims.getSubject();
		if(key != null && !key.trim().equals("")) {
			JSONObject json = JSONObject.parseObject(subject);
			return json.getString(key);
		} else {
			return subject;
		}
	}

}

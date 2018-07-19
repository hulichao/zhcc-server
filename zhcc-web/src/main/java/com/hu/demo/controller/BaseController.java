package com.hu.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;
import com.hu.demo.util.JwtUtils;

import io.jsonwebtoken.Claims;

/**
 * Controllerg公用基类
 * 包含全局异常和jwt--> subject
 *
 * @author hulichao
 * @date 2018/3/15
 */
public class BaseController {
    
    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(HttpServletRequest request, Exception e) {
    	//FIXME
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("系统管理员跑路拉，您再自己瞅瞅吧");
    }
	
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

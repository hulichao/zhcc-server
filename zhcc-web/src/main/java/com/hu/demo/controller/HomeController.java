package com.hu.demo.controller;


import com.hu.demo.dto.ResourceDTO;
import com.hu.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hu.demo.util.JwtUtils;

import java.util.List;

@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/index")
	public ModelAndView index(@CookieValue(value="jwt", required = false) String jwt) {
		if(jwt == null){
			ModelAndView result = new ModelAndView("login.html");
			return result;
		}
		//得到用户id
		String currentUserId = this.getSubjectFromJwt(jwtUtils, jwt, "userId");
		// 得到所有已授权的菜单
		List<ResourceDTO> list = this.resourceService.listAuthorizedByUserId(Integer.parseInt(currentUserId));
		ModelAndView result = new ModelAndView("index");
		result.addObject("menuList", list);
		return result;
	}

}

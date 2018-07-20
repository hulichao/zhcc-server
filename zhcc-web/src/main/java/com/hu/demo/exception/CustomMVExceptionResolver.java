package com.hu.demo.exception;
/**
 * Created by hulichao on 2018/7/17.
 */

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.hu.demo.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hulichao
 * @date 2018/7/17
 */
@ControllerAdvice
public class CustomMVExceptionResolver implements HandlerExceptionResolver {

    private static Logger log = LoggerFactory.getLogger(CustomMVExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        Result result = Result.fail();
        if (e instanceof DataIntegrityViolationException) {
            result.put("msg", "该角色尚有关联的资源或用户，删除失败!");
        }else {
            result.put("msg", "系统管理员跑路拉，您再自己瞅瞅吧");
        }

        FastJsonJsonView view = new FastJsonJsonView();
        view.setAttributesMap(result);
        mv.setView(view);
        log.debug("异常:" + e.getMessage(), e);
        return mv;
    }
}

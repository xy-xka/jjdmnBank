package com.org.jjdmn.bank.Interceptor;

import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.vo.ResultVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            ResultVo resultVo = (ResultVo) request.getSession().getAttribute("user");
            if (resultVo!=null) return true;
            response.sendRedirect(request.getContextPath()+"/");
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

}

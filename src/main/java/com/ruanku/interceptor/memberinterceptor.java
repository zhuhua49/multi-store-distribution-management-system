package com.ruanku.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(names = {"Name"})
public class memberinterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("memberName")!=null){
            System.out.println("会员已登录");
            return true;
        }
        else {
            System.out.println("会员未登录");
            request.getRequestDispatcher("/WEB-INF/pages/member/login.jsp").forward(request,response);
            return false;
        }
    }
}

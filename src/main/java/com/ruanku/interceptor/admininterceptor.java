package com.ruanku.interceptor;

import com.ruanku.domain.Administrator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(names = {"Admin"},types = {Administrator.class})
public class admininterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminName")!=null){
            System.out.println("店长已登录");
            return true;
        }
        else {
            System.out.println("店长未登录");
            request.getRequestDispatcher("/WEB-INF/pages/admin/login.jsp").forward(request,response);
            return false;
        }
    }
}

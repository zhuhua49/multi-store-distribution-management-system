package com.ruanku.handler;


import com.ruanku.domain.Administrator;
import com.ruanku.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.servlet.http.HttpSession;

@Component
@EnableWebSocket
@Controller
@SessionAttributes(names = {"Name","Admin"},types = {String.class,Administrator.class})
public class NzWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {


    /**
     * 当WebSocketHandler类被加载时就会创建该Integer，随类而生
     * 测试用的，用于分辨
     */
   //public static Integer count = 0;

    /**
     * 跳转到聊天View
     * @param session
     * @return

    @RequestMapping("/connwebsocket")
    public String conSocket(HttpSession session, Model model){
        count++;
        session.setAttribute("user", new User("用户" + count));
        System.out.println("控制端userId："+session.getAttribute("user"));
        return "websocket";
    }
     */

    @Autowired
    NzWebSocketHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        //添加websocket处理器，添加握手拦截器
        webSocketHandlerRegistry.addHandler(handler, "/handler").addInterceptors(new NzHandShakeInterceptor());

    }

}
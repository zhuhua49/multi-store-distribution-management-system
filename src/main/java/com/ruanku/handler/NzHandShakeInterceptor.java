package com.ruanku.handler;


import com.ruanku.domain.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class NzHandShakeInterceptor implements HandshakeInterceptor {

    /**
     * 握手前的处理
     * @param serverHttpRequest, serverHttpResponse, webSocketHandler, map
     * @return boolean
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("Websocket:用户[ID:" + ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false).getAttribute("user") + "]已经建立连接");
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            // 标记用户
            User user = (User) session.getAttribute("user");
            if (user != null) {
                // 为服务器创建WebSocketSession做准备
                map.put("userId", user.getUserId());
                System.out.println("用户id：" + user.getUserId() + " 被加入");
            } else {
                System.out.println("user为空");
                return false;
            }
        }
        return true;
    }


    /**
     * 握手后的处理
     * @param serverHttpRequest, serverHttpResponse, webSocketHandler, excption
     */
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception excption) {

    }

}
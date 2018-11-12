package com.perye.websocket.controller;


import com.perye.websocket.bean.Message;
import com.perye.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author: Perye
 * @create: 2018-11-12 14:55
 **/
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, Message message) {
        /**
         * 此处是一段硬编码。如果发送人是perye 则发送给 admin 如果发送人是admin 就发送给 perye。
         */
        if (principal.getName().equals("perye")) {
            //通过convertAndSendToUser 向用户发送信息,
            // 第一个参数是接收消息的用户,第二个参数是浏览器订阅的地址,第三个参数是消息本身
            simpMessagingTemplate.convertAndSendToUser("admin","/queue/notifications", principal.getName() + "send:" + message.getName());
        } else {
            simpMessagingTemplate.convertAndSendToUser("perye","/queue/notifications", principal.getName() + "send:" + message.getName());
        }
    }

}

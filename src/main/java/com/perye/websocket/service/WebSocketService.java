package com.perye.websocket.service;

import com.perye.websocket.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @author: Perye
 * @create: 2018-11-12 15:19
 **/
@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1500);
            simpMessagingTemplate.convertAndSend("/topic/getResponse",new Response("Welcome,websocket!"+i));
            System.out.println("----------------------send"+i);
        }

    }

}

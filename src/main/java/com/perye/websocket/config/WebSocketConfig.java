package com.perye.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author: Perye
 * @create: 2018-11-12 14:37
 **/
@Configuration
@EnableWebSocketMessageBroker
//通过EnableWebSocketMessageBroker开启STOMP协议来传输基于代理（message broker）的消息，此时浏览器支持使用@MessageMapping就像支持@RequestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    /**
     * endpoint注册协议节点，并映射到指定的url
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个名字为"endpointChat" 的endpoint,并指定 SockJS协议
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }


    /**
     * 配置消息代理(message broker)
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //点对点式增加一个/queue 消息代理
        registry.enableSimpleBroker("/queue","/topic");
    }
}

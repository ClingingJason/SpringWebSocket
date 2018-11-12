package com.perye.websocket.bean;

/**
 * 服务器向浏览器发送的此类消息
 * @author: Perye
 * @create: 2018-11-12 14:53
 **/
public class Response {

    private String responseMessage;

    public Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

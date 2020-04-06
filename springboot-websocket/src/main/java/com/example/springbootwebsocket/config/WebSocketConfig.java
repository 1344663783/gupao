package com.example.springbootwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 注入 ServerEndpointExporter 配置，如果是使用 springboot
 * 内置的 tomcat 此配置必须，如果是使用的是外部 tomcat
 * 容器此步骤请忽略。看 spring 源码中这样描述，
 * 使用此配置可以关闭 servlet 容器对 websocket 端点的扫描，
 * 这个暂时没有深入研究。
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

package com.ms.microservice.sender.sender;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SendingMessage extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=5000")
                .transform().constant("Body of producer for Active MQ message ver 2")
                .log("sending message to ActiveMq - ${body}")
                .to("activemq:my-activemq-queue");
    }
}

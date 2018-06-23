package com.dom.mqtt.reactor.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SampleMqttApplication {

    @Autowired
    private MqttConsumer mqttConsumer;

    public static void main(String[] args) {
        SpringApplication.run(SampleMqttApplication.class);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void startConsumers() {
        mqttConsumer.consumerMessages();
    }
}

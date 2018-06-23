package com.dom.mqtt.reactor.sample;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;

@Configuration
public class MqttConfig {

    @Bean
    public IMqttClient mqttClient() throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", "mqtt-reactor", new MemoryPersistence());
        client.connect(connectionOptions());
        return client;
    }

    @Bean
    public MqttConnectOptions connectionOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName("test");
        options.setPassword("test".toCharArray());
        options.setCleanSession(true);
        options.setKeepAliveInterval(30);
        return options;
    }

    @Bean
    public EmitterProcessor<MqttMessage> emitterProcessor() {
        return EmitterProcessor.create();
    }
}

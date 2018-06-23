package com.dom.mqtt.reactor.sample;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MqttConsumer {

    private MqttReceiver mqttReceiver;

    public MqttConsumer(MqttReceiver mqttReceiver) {
        this.mqttReceiver = mqttReceiver;
    }

    public void consumerMessages() {
        Flux<MqttMessage> mqttMessageFlux = mqttReceiver.receive();
        mqttMessageFlux.subscribe(m ->
                System.out.println("Message received: " + m.getTopic() + " - " + m.getPayload()));
    }
}

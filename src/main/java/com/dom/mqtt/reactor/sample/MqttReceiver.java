package com.dom.mqtt.reactor.sample;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Service
public class MqttReceiver {


    private IMqttClient mqttClient;

    private EmitterProcessor<MqttMessage> emitterProcessor;

    public MqttReceiver(IMqttClient mqttClient, EmitterProcessor<MqttMessage> emitterProcessor) {
        this.mqttClient = mqttClient;
        this.emitterProcessor = emitterProcessor;
    }

    public Flux<MqttMessage> receive() {
        try {
            mqttClient.subscribe("topic/sample", (topic, message) ->
                    emitterProcessor.onNext(new MqttMessage(topic, new String(message.getPayload()))));
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return emitterProcessor;
    }
}

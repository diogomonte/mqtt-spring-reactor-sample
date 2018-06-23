package com.dom.mqtt.reactor.sample;

public class MqttMessage {

    private String topic;
    private String payload;

    public MqttMessage(String topic, String payload) {
        this.topic = topic;
        this.payload = payload;
    }

    public String getTopic() {
        return topic;
    }

    public String getPayload() {
        return payload;
    }
}

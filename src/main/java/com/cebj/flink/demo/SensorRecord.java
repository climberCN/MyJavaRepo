package com.cebj.flink.demo;

public class SensorRecord {
    private String id;
    private Long timestamp;
    private Double temperature;

    public SensorRecord() {}

    public SensorRecord(String id, Long timestamp, Double temperature) {
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "id: " + id + "\t" + "timestamp: " + timestamp + "\t" + "temperature: " + temperature;
    }

    public String getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
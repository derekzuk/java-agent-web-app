package com.derek.metricwebapp.domain;

public class RequestRecord {
    private String UUID;
    private String methodName;
    private long duration;
    private long responseSize;

    public RequestRecord() { }

    public RequestRecord(String UUID, String methodName, long duration, long responseSize) {
        this.UUID = UUID;
        this.methodName = methodName;
        this.duration = duration;
        this.responseSize = responseSize;
    }

    public String getUUID() {
        return UUID;
    }

    public String getMethodName() {
        return methodName;
    }

    public long getDuration() {
        return duration;
    }

    public long getResponseSize() {
        return responseSize;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}

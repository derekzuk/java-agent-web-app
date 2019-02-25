package com.derek.metricwebapp.domain;

import java.util.Objects;

public class MetricForDisplay {

    private  String methodName;
    private final String responseUniqueID;
    private final long avgResponseSize;
    private final long minResponseSize;
    private final long maxResponseSize;
    private final long avgResponseTime;
    private final long minResponseTime;
    private final long maxResponseTime;

    public MetricForDisplay(String methodName, String responseUniqueID, long avgResponseTime, long minResponseTime, long maxResponseTime,
                            long avgResponseSize, long minResponseSize, long maxResponseSize) {
        this.methodName = methodName;
        this.responseUniqueID = responseUniqueID;
        this.avgResponseTime = avgResponseTime;
        this.minResponseTime = minResponseTime;
        this.maxResponseTime = maxResponseTime;
        this.avgResponseSize = avgResponseSize;
        this.minResponseSize = minResponseSize;
        this.maxResponseSize = maxResponseSize;
    }

    public MetricForDisplay(String methodName, MetricRecord metricRecord) {
        this.methodName = methodName;
        this.responseUniqueID = null;
        this.avgResponseTime = metricRecord.getAvgDuration();
        this.minResponseTime = metricRecord.getMinDuration();
        this.maxResponseTime = metricRecord.getMaxDuration();
        this.avgResponseSize = metricRecord.getAvgResponseSize();
        this.minResponseSize = metricRecord.getMinResponseSize();
        this.maxResponseSize = metricRecord.getMaxResponseSize();
    }

    public String getResponseUniqueID() {
        return responseUniqueID;
    }

    public long getAvgResponseTime() {
        return avgResponseTime;
    }

    public long getMinResponseTime() {
        return minResponseTime;
    }

    public long getMaxResponseTime() {
        return maxResponseTime;
    }

    public String getMethodName() {
        return methodName;
    }

    public long getAvgResponseSize() {
        return avgResponseSize;
    }

    public long getMinResponseSize() {
        return minResponseSize;
    }

    public long getMaxResponseSize() {
        return maxResponseSize;
    }

    @Override
    public String toString() {
        return "MetricForDisplay{" +
                "methodName='" + methodName + '\'' +
                ", responseUniqueID='" + responseUniqueID + '\'' +
                ", avgResponseSize=" + avgResponseSize +
                ", minResponseSize=" + minResponseSize +
                ", maxResponseSize=" + maxResponseSize +
                ", avgResponseTime=" + avgResponseTime +
                ", minResponseTime=" + minResponseTime +
                ", maxResponseTime=" + maxResponseTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetricForDisplay metricForDisplay = (MetricForDisplay) o;
        return Objects.equals(methodName, metricForDisplay.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName);
    }
}
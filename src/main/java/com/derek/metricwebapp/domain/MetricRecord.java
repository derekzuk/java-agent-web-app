package com.derek.metricwebapp.domain;

public class MetricRecord {
    private long callCounts;
    private long avgDuration;
    private long minDuration;
    private long maxDuration;
    private long avgResponseSize;
    private long minResponseSize;
    private long maxResponseSize;

    public MetricRecord() {

    }

    public MetricRecord(final long callCounts,
                        final long avgDuration,
                        final long minDuration,
                        final long maxDuration,
                        final long avgResponseSize,
                        final long minResponseSize,
                        final long maxResponseSize) {
        this.callCounts = callCounts;
        this.avgDuration = avgDuration;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.avgResponseSize = avgResponseSize;
        this.minResponseSize = minResponseSize;
        this.maxResponseSize = maxResponseSize;
    }

    public MetricRecord(long callCounts, long duration, long responseSize) {
        this.callCounts = callCounts;
        this.avgDuration = duration;
        this.minDuration = duration;
        this.maxDuration = duration;
        this.avgResponseSize = responseSize;
        this.minResponseSize = responseSize;
        this.maxResponseSize = responseSize;
    }

    public long getCallCounts() {
        return callCounts;
    }

    public long getAvgDuration() {
        return avgDuration;
    }

    public long getMinDuration() {
        return minDuration;
    }

    public long getMaxDuration() {
        return maxDuration;
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
}

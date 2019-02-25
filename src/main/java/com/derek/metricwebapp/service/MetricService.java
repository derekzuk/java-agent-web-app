package com.derek.metricwebapp.service;

import com.derek.metricwebapp.domain.MetricForDisplay;
import com.derek.metricwebapp.domain.RequestRecord;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricService {

    private List<MetricForDisplay> metricForDisplayList = new ArrayList<>();
    private Map<String, MetricForDisplay> metricMap = new HashMap<>();
    private List<RequestRecord> requestRecords = new ArrayList<>();
    private Map<String, RequestRecord> requestRecordMap = new HashMap<>();

    public void runMetric(MetricForDisplay metricForDisplay) {
        metricForDisplayList.add(metricForDisplay);
        produceMetricSet(metricForDisplay);
    }

    public void produceMetricSet(MetricForDisplay metricForDisplay) {
        if (metricMap.containsKey(metricForDisplay.getMethodName())) {
            MetricForDisplay existingMetricForDisplay = metricMap.get(metricForDisplay.getMethodName());
            long avgResponseSize = metricForDisplay.getAvgResponseSize();
            long minResponseSize = metricForDisplay.getMinResponseSize() < existingMetricForDisplay.getMinResponseSize()
                    ? metricForDisplay.getMinResponseSize() : existingMetricForDisplay.getMinResponseSize();
            long maxResponseSize = metricForDisplay.getMaxResponseSize() > existingMetricForDisplay.getMaxResponseSize()
                    ? metricForDisplay.getMaxResponseSize() : existingMetricForDisplay.getMaxResponseSize();
            long avgResponseTime = metricForDisplay.getAvgResponseTime();
            long minResponseTime = metricForDisplay.getMinResponseTime() < existingMetricForDisplay.getMinResponseTime()
                    ? metricForDisplay.getMinResponseTime() : existingMetricForDisplay.getMinResponseTime();
            long maxResponseTime = metricForDisplay.getMaxResponseTime() > existingMetricForDisplay.getMaxResponseTime()
                    ? metricForDisplay.getMaxResponseTime() : existingMetricForDisplay.getMaxResponseTime();
            metricMap.put(metricForDisplay.getMethodName(),
                    new MetricForDisplay(metricForDisplay.getMethodName(),
                            null,
                            avgResponseTime,
                            minResponseTime,
                            maxResponseTime,
                            avgResponseSize,
                            minResponseSize,
                            maxResponseSize));
        } else {
            metricMap.put(metricForDisplay.getMethodName(), metricForDisplay);
        }
    }

    public List<MetricForDisplay> getMetricForDisplayList() {
        return metricForDisplayList;
    }

    public Map<String, MetricForDisplay> getMetricMap() {
        return metricMap;
    }

    public void saveRequestRecords(Map<String, RequestRecord> requestRecordMap) {
        Iterator iterator = requestRecordMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            RequestRecord requestRecord = (RequestRecord) pair.getValue();
            // The UUID is mysteriously nullified on the way here, so we re-set it:
            requestRecord.setUUID((String) pair.getKey());
            this.requestRecords.add(requestRecord);
            this.requestRecordMap.put(requestRecord.getUUID(), requestRecord);
            iterator.remove(); // avoids a ConcurrentModificationException
        }
    }

    public List<RequestRecord> getRequestRecordList() {
        return requestRecords;
    }

    public RequestRecord getRequestRecordByUUID(String UUID) {
        return requestRecordMap.get(UUID);
    }
}

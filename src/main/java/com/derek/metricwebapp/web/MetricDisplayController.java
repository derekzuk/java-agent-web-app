package com.derek.metricwebapp.web;

import com.derek.metricwebapp.domain.MetricForDisplay;
import com.derek.metricwebapp.domain.MetricRecord;
import com.derek.metricwebapp.domain.RequestRecord;
import com.derek.metricwebapp.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class MetricDisplayController {

    @Autowired
    MetricService metricService;

    @PostMapping("/processMetricRecords")
    public void processMetricRecords(@RequestBody Map<String, MetricRecord> metricRecordMap) {
        Iterator iterator = metricRecordMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            MetricRecord metricRecord = (MetricRecord) pair.getValue();
            MetricForDisplay metricForDisplay = new MetricForDisplay((String) pair.getKey(), metricRecord);
            metricService.runMetric(metricForDisplay);
            iterator.remove(); // avoids a ConcurrentModificationException
        }
    }

    @PostMapping("/processRequestRecords")
    public void processRequestRecords(@RequestBody Map<String, RequestRecord> requestRecordMap) {
        metricService.saveRequestRecords(requestRecordMap);
    }

    @GetMapping("/getMetricList")
    public List<MetricForDisplay> getMetricList() {
        return metricService.getMetricForDisplayList();
    }

    @GetMapping("/getMetricMap")
    public Map<String, MetricForDisplay> getMetricMap() {
        return metricService.getMetricMap();
    }

    @GetMapping("/getRequestRecords")
    public List<RequestRecord> getRequestRecords() {
        return metricService.getRequestRecordList();
    }

    @GetMapping("/getRequestRecordByUUID/{uuid}")
    public RequestRecord getRequestRecordByUUID(@PathVariable String uuid) {
        return metricService.getRequestRecordByUUID(uuid);
    }
}

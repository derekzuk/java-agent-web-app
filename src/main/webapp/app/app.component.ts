import {Component, OnInit} from '@angular/core';
import { MetricService } from "./service/metric.service";
import { RequestRecord } from "./model/requestrecord.model";
import {MetricMapItem} from "./model/metricMapItem.model";
import {Metric} from "./model/metric.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'web';
  requestRecords: RequestRecord[] = [];
  specificRequest: RequestRecord;
  metricMap = new Map<string, Metric>();

    constructor(private metricService: MetricService){}

  ngOnInit() {
      this.metricService.getRequestRecords().subscribe((requestRecords) => {
          this.requestRecords = requestRecords;
      });
      this.metricService.getMetricMap().subscribe((metricMap) => {
          this.metricMap = metricMap;
      })
  }

  getMetricByUUID(uuid: string) {
      this.metricService.getRequestRecordByUUID(uuid).subscribe((specificRequest) => {
          this.specificRequest = specificRequest;
      })
  }
}

import {Metric} from "./metric.model";

export interface MetricMapItem {
    methodName: string;
    parameters: { metric: Metric };
}
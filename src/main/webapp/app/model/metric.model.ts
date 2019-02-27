export interface IMetric {
    methodName?: string;
    responseUniqueID?: string;
    avgResponseSize?: number;
    minResponseSize?: number;
    maxResponseSize?: number;
    avgResponseTime?: number;
    minResponseTime?: number;
    maxResponseTime?: number;
}

export class Metric implements IMetric {
    constructor(
        public methodName?: string,
        public responseUniqueID?: string,
        public avgResponseSize?: number,
        public minResponseSize?: number,
        public maxResponseSize?: number,
        public avgResponseTime?: number,
        public minResponseTime?: number,
        public maxResponseTime?: number,
    ) {
        this.methodName = methodName ? methodName : null;
        this.responseUniqueID = responseUniqueID ? responseUniqueID : null;
        this.avgResponseSize = avgResponseSize ? avgResponseSize : null;
        this.minResponseSize = minResponseSize ? minResponseSize : null;
        this.maxResponseSize = maxResponseSize ? maxResponseSize : null;
        this.avgResponseTime = avgResponseTime ? avgResponseTime : null;
        this.minResponseTime = minResponseTime ? minResponseTime : null;
        this.maxResponseTime = maxResponseTime ? maxResponseTime : null;
    }
}
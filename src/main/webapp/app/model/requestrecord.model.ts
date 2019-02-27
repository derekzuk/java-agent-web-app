export interface IRequestRecord {
    uuid?: string;
    methodName?: string;
    duration?: number;
    responseSize?: number;
}

export class RequestRecord implements IRequestRecord {
    constructor(
        public uuid?: string,
        public methodName?: string,
        public duration?: number,
        public responseSize?: number
    ) {
        this.uuid = uuid ? uuid : null;
        this.methodName = methodName ? methodName : null;
        this.duration = duration ? duration : null;
        this.responseSize = responseSize ? responseSize : null;
    }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MetricService {
  readonly endpoint = 'http://localhost:8081/';
  readonly httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getRequestRecords(): Observable<any> {
      return this.http.get(this.endpoint + 'getRequestRecords', { observe: 'response' })
          .pipe(map((res: HttpResponse<any>) => {
              return res.body;
          }));
  }

  getMetricMap(): Observable<any> {
    return this.http.get(this.endpoint + 'getMetricMap', {observe: "response"})
        .pipe(map((res: HttpResponse<any>) => {
          console.log(res.body);
            return res.body;
        }));
  }

  getRequestRecordByUUID(uuid: string): Observable<any> {
    return this.http.get(this.endpoint + 'getRequestRecordByUUID/' + uuid, {observe: "response"})
        .pipe(map((res: HttpResponse<any>) => {
            return res.body;
        }));
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

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
      return this.http.get(this.endpoint + 'getRequestRecords', { observe: 'response' });
  }
}

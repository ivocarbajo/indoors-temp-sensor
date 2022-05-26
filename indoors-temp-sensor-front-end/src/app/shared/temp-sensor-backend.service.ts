import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Reading } from './reading.class';

@Injectable({
    providedIn: 'root',
})
export class TempSensorBackendService {
    base_url = 'http://localhost:8080/api/';

    constructor(private http: HttpClient) {}

    fetchReadings(limit?: number): Observable<Reading[]> {
        if (limit != null) {
            let params: HttpParams = new HttpParams().set('limit', limit);
        }

        return this.http.get<Reading[]>(this.base_url + 'reading/getLatestReadings');
    }
}

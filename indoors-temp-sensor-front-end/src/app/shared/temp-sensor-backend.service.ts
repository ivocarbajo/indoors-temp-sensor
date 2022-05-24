import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Reading } from './reading.interface';

@Injectable({
    providedIn: 'root',
})
export class TempSensorBackendService {
    base_url = 'http://localhost:8080/api/';

    constructor(private http: HttpClient) {}

    fetchReadings(): Observable<Reading[]> {
        return this.http.get<Reading[]>(this.base_url + 'reading');
    }
}

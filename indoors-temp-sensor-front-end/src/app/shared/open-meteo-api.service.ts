import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OpenMeteoApiResponse } from './open-meteo-api-response.interface';

@Injectable({
    providedIn: 'root',
})
export class OpenMeteoApiService {
    url: string = 'https://api.open-meteo.com/v1/forecast?latitude=41.42&longitude=2.16&hourly=temperature_2m';

    constructor(private httpClient: HttpClient) {}

    getOpenMeteoForecast() {
        this.httpClient.get<OpenMeteoApiResponse>(this.url);
    }
}

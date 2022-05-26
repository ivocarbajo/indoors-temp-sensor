import { Component, OnInit } from '@angular/core';
import { Reading } from 'src/app/shared/reading.class';
import { TempSensorBackendService } from 'src/app/shared/temp-sensor-backend.service';

@Component({
    selector: 'app-indicators',
    templateUrl: './indicators.component.html',
    styleUrls: ['./indicators.component.scss'],
})
export class IndicatorsComponent implements OnInit {
    reading: Reading = new Reading();

    constructor(private tempSensorBackendService: TempSensorBackendService) {}

    ngOnInit(): void {
        this.tempSensorBackendService.fetchReadings(1).subscribe((readings) => {
            this.reading = readings[0];
        });
    }
}

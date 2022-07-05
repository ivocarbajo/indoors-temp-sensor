import { Component, OnInit, ViewChild } from '@angular/core';
import { Reading } from 'src/app/shared/reading.class';
import { TempSensorBackendService } from 'src/app/shared/temp-sensor-backend.service';
import { ApexAxisChartSeries, ApexChart, ApexNoData, ApexXAxis, ChartComponent } from 'ng-apexcharts';
import { JsonpClientBackend } from '@angular/common/http';

export interface ChartOptions {
    series: ApexAxisChartSeries;
    chart: ApexChart;
    noData: ApexNoData;
    xaxis: ApexXAxis;
}

@Component({
    selector: 'app-temperature-chart',
    templateUrl: './temperature-chart.component.html',
    styleUrls: ['./temperature-chart.component.scss'],
})
export class TemperatureChartComponent implements OnInit {
    readings: Reading[] = [];

    chartOptions: ChartOptions;

    constructor(private tempSensorBackendService: TempSensorBackendService) {
        this.chartOptions = {
            series: [],
            chart: {
                height: 350,
                type: 'line',
                zoom: {
                    enabled: true,
                    type: 'x',
                    autoScaleYaxis: true,
                },
            },
            noData: {
                text: 'Loading...',
            },
            xaxis: {
                type: 'datetime',
            },
        };
    }

    ngOnInit(): void {
        this.tempSensorBackendService.fetchReadings().subscribe((readings) => {
            this.readings = readings;

            this.chartOptions.series = [
                {
                    name: 'Temperature (ºC)',
                    data: this.readings.map((reading) => {
                        return {
                            x: new Date(reading.date).getTime(),
                            y: reading.temperature,
                        };
                    }),
                },
                {
                    name: 'Humidity (%)',
                    data: this.readings.map((reading) => {
                        return {
                            x: new Date(reading.date).getTime(),
                            y: reading.humidity,
                        };
                    }),
                },
            ];
        });
    }
}

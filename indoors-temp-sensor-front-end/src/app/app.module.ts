import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from 'src/material.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TemperatureChartComponent } from './homepage/components/temperature-chart/temperature-chart.component';
import { HttpClientModule } from '@angular/common/http';
import { NgApexchartsModule } from 'ng-apexcharts';
import { HomepageComponent } from './homepage/homepage.component';
import { IndicatorsComponent } from './homepage/components/indicators/indicators.component';

@NgModule({
    declarations: [AppComponent, TemperatureChartComponent, HomepageComponent, IndicatorsComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        NgbModule,
        HttpClientModule,
        NgApexchartsModule,
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}

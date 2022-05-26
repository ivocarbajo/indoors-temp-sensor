interface Units {
    temperature_2m: string;
    time: string;
}

interface TemperatureRecords {
    temperature_2m: number[];
    time: string[];
}

export interface OpenMeteoApiResponse {
    longitude: number;
    elevation: number;
    latitude: number;
    generationtime_ms: number;
    hourly_units: Units;
    utc_offset_seconds: number;
    hourly: TemperatureRecords;
}

import { TestBed } from '@angular/core/testing';

import { TempSensorBackendService } from './temp-sensor-backend.service';

describe('TempSensorBackendService', () => {
  let service: TempSensorBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TempSensorBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { OpenMeteoApiService } from './open-meteo-api.service';

describe('OpenMeteoApiService', () => {
  let service: OpenMeteoApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OpenMeteoApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

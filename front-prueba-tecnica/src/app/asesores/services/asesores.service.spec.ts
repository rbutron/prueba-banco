import { TestBed } from '@angular/core/testing';

import { AsesoresService } from './asesores.service';

describe('AsesoresService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AsesoresService = TestBed.get(AsesoresService);
    expect(service).toBeTruthy();
  });
});

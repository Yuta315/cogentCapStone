import { TestBed } from '@angular/core/testing';

import { RefillService } from './refill.service';

describe('RefillService', () => {
  let service: RefillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RefillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

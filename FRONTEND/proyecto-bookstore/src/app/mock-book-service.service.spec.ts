import { TestBed } from '@angular/core/testing';

import { MockBookServiceService } from './mock-book-service.service';

describe('MockBookServiceService', () => {
  let service: MockBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MockBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

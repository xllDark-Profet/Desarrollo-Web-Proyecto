import { TestBed } from '@angular/core/testing';

import { BookGuardService } from './book-guard.service';

describe('BookGuardService', () => {
  let service: BookGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

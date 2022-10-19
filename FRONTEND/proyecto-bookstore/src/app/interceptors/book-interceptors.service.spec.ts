import { TestBed } from '@angular/core/testing';

import { BookInterceptorsService } from './book-interceptors.service';

describe('BookInterceptorsService', () => {
  let service: BookInterceptorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookInterceptorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

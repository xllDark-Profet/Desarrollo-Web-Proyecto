import { TestBed } from '@angular/core/testing';
import {LoginService } from './login.service';
import { user } from '../login/user';

describe('LoginService', () => {
  let service: LoginService;
  let spy: any

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should not be null',()=>{
    spy=spyOn(service, "login").and.returnValues
    const result =service.login(new user("mariro", "1234"));
    expect(result).not.toBeNull;
  })
});

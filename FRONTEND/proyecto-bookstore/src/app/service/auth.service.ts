import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewUser } from '../models/new-user';
import { LoginUser } from '../models/login-user';
import { JwtDTO } from '../models/jwt-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = 'http://localhost:8080/auth/';

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario: NewUser): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'new-user', nuevoUsuario);
  }

  public login(loginUsuario: LoginUser): Observable<JwtDTO> {
    return this.httpClient.post<JwtDTO>(this.authURL + 'login-user', loginUsuario);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { CookieService } from "ngx-cookie-service";
import { user } from '../login/user';
import { Person } from '../register/person';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  personURL = 'http://localhost:8083/persons/';

  constructor(private http: HttpClient,
    private cookies: CookieService) { }

    public personlist(): Observable<Person[]>{
      return this.http.get<Person[]>(this.personURL + 'lista' )
    }

    login(userLogin: user): Observable<any>{
      const headers = new HttpHeaders();
      return this.http.post("http://localhost:8083/persons/login",userLogin);
    }

    setToken(token: string) {
      this.cookies.set("token", token);
    }
    getToken() {
      return this.cookies.get("token");
    }  


}

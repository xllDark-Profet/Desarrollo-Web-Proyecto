import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Person } from './register/person';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  register(personRegister:Person): Observable<any>{
    return this.http.post("http://localhost:8083/persons/personNewPerson",personRegister, {responseType: 'text'});
  }
}

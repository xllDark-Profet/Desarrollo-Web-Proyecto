import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Person } from './register/person';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
/**
 * Constructor de la clase
 * @param http 
 */
  constructor(private http: HttpClient) { }
/**
 * El metodo recibe la persona que se va a registrar en la libreria y la envia al backend a traves de la url indicada. 
 * @param personRegister 
 * @returns una cadena que indica el resultado de la operacion 
 */
  register(personRegister:Person): Observable<any>{
    return this.http.post("http://localhost:8083/persons/personNewPerson",personRegister, {responseType: 'text'});
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { CookieService } from "ngx-cookie-service";
import { user } from '../login/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,
    private cookies: CookieService) { }
    /**
     * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que autentica a un usuario 
     * en el sistema 
     * @param userLogin 
     * @returns objeto con el token 
     */
    login(userLogin: user): Observable<any>{
      const headers = new HttpHeaders();
      return this.http.post("http://localhost:8083/persons/login",userLogin);
    }
    /**
     * Este metodo se encarga hacer la modificacion de las cookies con el token recibido 
     * @param token 
     */
    setToken(token: string) {
      this.cookies.set("token", token);
    }
    /**
     * Este metodo se encarga de obtener el token de las cookies
     * @returns 
     */
    getToken() {
      return this.cookies.get("token");
    }  
}

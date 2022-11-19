import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Editorial } from '../models/editorial';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {
  editorialURL = 'http://localhost:8082/editorial/';

  constructor(private httpClient: HttpClient) { }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que  regresa la lista de editoriales 
   * registrados en la base de datos de la libreria 
   * @returns lista de editoriales 
   */
  public editoriallist(): Observable<Editorial[]>{
    return this.httpClient.get<Editorial[]>(this.editorialURL + 'lista' )
  }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que regresa la editorial que corresponde 
   * al id 
   * @param id 
   * @returns editorial que corresponde al id
   */
  public editorialdetail(id: number): Observable<Editorial>{
    return this.httpClient.get<Editorial>(this.editorialURL + `detail/${id}` )
  }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que regresa la editorial que 
   * corresponde al nombre
   * @param name 
   * @returns 
   */
  public editorialdetailname(name: string): Observable<Editorial>{
    return this.httpClient.get<Editorial>(this.editorialURL + `detailname/${name}` )
  }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que crea una editorial en la base de datos 
   * @param editorial 
   * @returns mensaje con el resultado de la operacion 
   */
  public save(editorial: Editorial): Observable<any>{
    return this.httpClient.post<any>(this.editorialURL + 'create', editorial);
  }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que modifica una editorial dado 
   * el id de la misma 
   * @param id 
   * @param editorial 
   * @returns mensaje con el resultado de la operacion 
   */
  public update(id: number, editorial:Editorial): Observable<any>{
    return this.httpClient.put<any>(this.editorialURL + `update/${id}`, editorial);
  }
  /**
   * Este metodo se encarga de hacer la conexion con el back a traves de la url indicada que elimina una editorial 
   * de la base de datos dado un id 
   * @param id 
   * @returns mensaje con el resultado de la operacion
   */
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.editorialURL + `delete/${id}`);
  }
}

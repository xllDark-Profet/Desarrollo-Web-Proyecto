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

  public editoriallist(): Observable<Editorial[]>{
    return this.httpClient.get<Editorial[]>(this.editorialURL + 'lista' )
  }

  public editorialdetail(id: number): Observable<Editorial>{
    return this.httpClient.get<Editorial>(this.editorialURL + `detail/${id}` )
  }

  public editorialdetailname(name: string): Observable<Editorial>{
    return this.httpClient.get<Editorial>(this.editorialURL + `detailname/${name}` )
  }

  public save(editorial: Editorial): Observable<any>{
    return this.httpClient.post<any>(this.editorialURL + 'create', editorial);
  }

  public update(id: number, editorial:Editorial): Observable<any>{
    return this.httpClient.put<any>(this.editorialURL + `update/${id}`, editorial);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.editorialURL + `delete/${id}`);
  }
}

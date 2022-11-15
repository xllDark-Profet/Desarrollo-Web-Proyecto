import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  bookURL = 'http://localhost:8081/book/';


  constructor(private httpClient: HttpClient) { }

  public booklist(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(this.bookURL + 'lista' )
  }

  public bookdetail(id: number): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `detail/${id}` )
  }

  public bookdetailname(name: string): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `detailname/${name}` )
  }

  public save(book: Book): Observable<any>{
    return this.httpClient.post<any>(this.bookURL + 'create', book);
  }

  public update(id: number, book:Book): Observable<any>{
    return this.httpClient.put<any>(this.bookURL + `update/${id}`, book);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.bookURL + `delete/${id}`);
  }

  //Paginacion
  public paginar(page: number, size: number, order: string, asc: boolean): Observable<any> {
    return this.httpClient.get<any>(this.bookURL + `page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}

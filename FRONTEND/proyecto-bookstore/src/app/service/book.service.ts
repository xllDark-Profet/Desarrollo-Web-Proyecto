import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  bookURL = 'http://localhost:8080/book/';


  constructor(private httpClient: HttpClient) { }

  public booklist(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(this.bookURL + 'book-list' )
  }

  public bookdetail(id: number): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `book-detail/${id}` )
  }

  public bookdetailname(name: string): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `book-detail-name/${name}` )
  }

  public save(book: Book): Observable<any>{
    return this.httpClient.post<any>(this.bookURL + 'create-book', book);
  }

  public update(id: number, book:Book): Observable<any>{
    return this.httpClient.put<any>(this.bookURL + `update-book/${id}`, book);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.bookURL + `delete-book/${id}`);
  }
}

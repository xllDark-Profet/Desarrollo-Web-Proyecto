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
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada para regresar todos los libros 
   * registrados en la base de datos 
   * @returns lista de libros
   */
  public booklist(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(this.bookURL + 'lista' )
  }
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada para regresar el libro al que 
   * le corresponde el id indicado 
   * @param id 
   * @returns el libro correspondiente al id indicado
   */
  public bookdetail(id: number): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `detail/${id}` )
  }
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada para regresar el libro al 
   * que le corresponde el nombre indicado
   * @param name 
   * @returns el libro correspondiente al nombre indicado
   */

  public bookdetailname(name: string): Observable<Book>{
    return this.httpClient.get<Book>(this.bookURL + `detailname/${name}` )
  }

  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la  url senalada que crea un nuevo libro en la 
   * base de datos 
   * @param book 
   * @returns mensaje de exito o fallo de la operacion
   */
  public save(book: Book): Observable<any>{
    return this.httpClient.post<any>(this.bookURL + 'create', book);
  }
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada que se encarga de modificar 
   * los atributos de un libro  dado el id correspondiente
   * @param id 
   * @param book 
   * @returns mensaje de exito o fallo de la operacion
   */
  public update(id: number, book:Book): Observable<any>{
    return this.httpClient.put<any>(this.bookURL + `update/${id}`, book);
  }
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada y se encarga de eliminar 
   * un libro de la base de datos dado el id de este 
   * @param id 
   * @returns mensaje de exito o fallo de la operacion
   */
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.bookURL + `delete/${id}`);
  }
  /**
   * Este metodo se encarga de realizar la conexion con el back a traves de la url senalada para realizar la paginacion 
   * de los resultados
   * @param page 
   * @param size 
   * @param order 
   * @param asc 
   * @returns  paginacion resultados
   */
  //Paginacion
  public paginar(page: number, size: number, order: string, asc: boolean): Observable<any> {
    return this.httpClient.get<any>(this.bookURL + `page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}

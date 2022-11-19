import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BehaviorSubject } from 'rxjs';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-crud-table-book',
  templateUrl: './crud-table-book.component.html',
  styleUrls: ['./crud-table-book.component.css']
})
export class CrudTableBookComponent implements OnInit {
  /**
   * Arreglo en el que se guardara la lista de libros
   */
  books: Book[] = [];
  /**
   * Constructor del componente
   * @param bookService 
   * @param http 
   * @param toastr 
   * @param router 
   */
  constructor(private bookService: BookService, private http:HttpClient, private toastr: ToastrService,
    private router: Router) { }
  /**
   * metodo que carga la lista de libros cuando se inicia la aplicacion 
   */
  ngOnInit(): void {
    this.cargarBooks();
    this.cargarPaginas;
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio que lista todos los libros traidos desde el backend. 
   */
  cargarBooks(): void{
    this.bookService.booklist().subscribe(
      data =>{
        this.books = data; 
      },
      err => {
        console.log(err);
      }
    )
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio que elimina un libro dado un id 
   * @param id 
   */
  borrar(id?: number){
    if (id != undefined){
      this.bookService.delete(id).subscribe(
        data => {
          this.toastr.success('Producto Eliminado','OK', {
            timeOut: 3000,
            positionClass: 'toast-top-center'
          });
          this.router.navigate(['/book-table']);
          this.cargarBooks;
          
        },
        err => {
          this.toastr.error(err.error.mensaje,'Fail', {
            timeOut: 3000,
            positionClass: 'toast-top-center'
          });
        }
      );
    }
  }

  page = 0;
  size = 1;
  order = 'id';
  asc = true;

  totalPages: Array<number> = [];

  isFirst = false;
  isLast = false;

  cargarPaginas() {
    this.bookService.paginar(this.page, this.size, this.order, this.asc).subscribe(
      data => {
        this.books = data.content;
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data['totalPages']);
        console.log(data);
      },
      err => {
        console.log(err.error);
      }
    );
  }


  sort(): void {
    this.asc = !this.asc;
    this.cargarBooks();
  }

  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.cargarBooks();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.cargarBooks();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.cargarBooks();
  }
  
  setOrder(order: string): void {
    this.order = order;
    this.cargarBooks();
  }

}

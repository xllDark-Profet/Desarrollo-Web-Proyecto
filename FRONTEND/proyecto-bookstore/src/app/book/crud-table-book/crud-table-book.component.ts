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

  books: Book[] = [];

  constructor(private bookService: BookService, private http:HttpClient, private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
    this.cargarBooks();
  }

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

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-lista-book',
  templateUrl: './lista-book.component.html',
  styleUrls: ['./lista-book.component.css']
})
export class ListaBookComponent implements OnInit {

  books: Book[] = [];




  book: Book = {

    nombre: '',
    descripcion: '',
    cantidad: 0,
    editorial: '',
    imagen_url: '',
    dia_edicion: ''

  }

  form = new FormGroup({  
    nombre : new FormControl() 
  });
  nombre: any;

  constructor(private bookService: BookService, private http:HttpClient) { }

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
    );
  }

  getData(bookname:any)  
  {  
      this.bookService.bookdetailname(bookname).subscribe(  
        response => {  
          this.book = response; 
        },  
        error => {  
          console.log("error while getting user Details");  
        }  
      );  
  }

  searchResults = new BehaviorSubject<Array<Book>>([]);

  searchByName(name:string){
    this.book.nombre = this.nombre;
    this.getData(this.book);
  }
  
}

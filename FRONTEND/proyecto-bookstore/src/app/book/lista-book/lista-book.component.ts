import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-lista-book',
  templateUrl: './lista-book.component.html',
  styleUrls: ['./lista-book.component.css']
})
export class ListaBookComponent implements OnInit {

  books: Book[] = [];

  constructor(private bookService: BookService) { }

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

}

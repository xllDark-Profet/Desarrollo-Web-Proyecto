import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
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
    )
  }

  searchResults = new BehaviorSubject<Array<Book>>([]);

  searchByName(name:string){
    this.http.get<Book[]>("http://localhost:8181/book-detail/" + name).subscribe(
      results => this.searchResults.next(results)
    );
  }
  buscar(searchForm: NgForm): void{
    this.bookService.bookdetailname(searchForm.value.filtro);
  }

  onResults(){
    return this.searchResults.asObservable();
  }

}

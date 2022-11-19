import { TestBed } from '@angular/core/testing';
import { ListaBookComponent } from '../book/lista-book/lista-book.component'; 
import { NuevoBookComponent } from '../book/nuevo-book/nuevo-book.component';
import { DetalleBookComponent } from '../book/detalle-book/detalle-book.component';
import { Book } from '../models/book';

import { BookService } from './book.service';

describe('BookService', () => {
  let service: BookService;
  let componentListar:ListaBookComponent;  
  let spy: any;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
 /*
  it ('should not be null', ()=>{
   spy=spyOn(service, "booklist").and.returnValues
   const result=service.booklist()
   expect(result).not.toBeNull;
  })

  it ('should be an error message', ()=>{
    let book
    service.bookdetail(1).subscribe(
        book 
    )
    expect(book).not.toBeNull;
   })
  
   it ('should be an error message', ()=>{
    let book
    service.bookdetailname("").subscribe(
      book     
    );
    expect(book).not.toBeNull;
   })*/


   

  



});

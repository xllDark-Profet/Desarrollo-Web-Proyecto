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
  /**
   * En este arreglo se guardaran los libros de la base de datos 
   */
  books: Book[] = [];
<<<<<<< Updated upstream




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

=======
  /**
   * Constructor del componente
   * @param bookService 
   * @param http 
   */
>>>>>>> Stashed changes
  constructor(private bookService: BookService, private http:HttpClient) { }
  /**
   * En este metodo se cargan los libros al iniciar la pagina
   */
  ngOnInit(): void {
    this.cargarBooks();
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio que lista los libros registrados en la libreria. 
   * Si la operacio falla se imprime en consola el mensaje de error.  
   */
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
  /**
   * En este arreglo se guardaran los resultados de la busqueda 
   */
  searchResults = new BehaviorSubject<Array<Book>>([]);
  /**
   * Este metodo se encarga de recuperar un libro dado un nombre de libro y ponerlo en el arreglo de resultados 
   * de busqueda
   * @param name 
   */
  searchByName(name:string){
    this.book.nombre = this.nombre;
    this.getData(this.book);
  }
<<<<<<< Updated upstream
  
=======
  /**
   * Este metodo se encarga de recuperar el nombre del libro que se desea buscar y llamar al metodo del servicio 
   * que dado un nombre devuelve un libro 
   * @param searchForm 
   */
  buscar(searchForm: NgForm): void{
    this.bookService.bookdetailname(searchForm.value.filtro);
  } 
  /**
   * Este metodo devuelve los libros producto del resultado de la busqueda
   * @returns  resultados de la busqueda
   */

  onResults(){
    return this.searchResults.asObservable();
  }

>>>>>>> Stashed changes
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Book } from 'src/app/models/book';
import { Editorial } from 'src/app/models/editorial';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-editar-book',
  templateUrl: './editar-book.component.html',
  styleUrls: ['./editar-book.component.css']
})
export class EditarBookComponent implements OnInit {
  /**
   * Objeto que representa el libro que se va a modificar
   */
  book!: Book;
  /**
   * Arreglo que contiene las editoriales que se pueden escoger
   */
  editorials: Editorial[] = [];
  /**
   * Constructor del componente
   * @param bookService 
   * @param activatedRoute 
   * @param toastr 
   * @param router 
   */
  constructor(
    private bookService: BookService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }
  /**
   * Este metodo llama al metodo del servicio que dado un id muestra los detalles de un libro, tan pronto se 
   * carga la pagina.
   * Si la operacion es fallida, se muestra un toast con un mensaje de error y se redirecciona a la tabla 
   */

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.bookService.bookdetail(id).subscribe(
      data => {
        this.book = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/book-table']);
      }
    );
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio que dado un id modifica el libro correspondiente
   * y posteriormente redirigir al usuario a la tabla. 
   * Si la operacion falla, se muestra un toast con un mensaje de error y se redirige a la tabla 
   */

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.bookService.update(id, this.book).subscribe(
      data => {
        this.toastr.success('Libro Actualizado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/book-table']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/book-table']);
      }
    );
  }

}

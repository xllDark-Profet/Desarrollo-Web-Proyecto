import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-detalle-book',
  templateUrl: './detalle-book.component.html',
  styleUrls: ['./detalle-book.component.css']
})
export class DetalleBookComponent implements OnInit {
  /**
   * Libro que corresponde al libro sobre el cual se quieren saber los detalles 
   */
  book?: Book;
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
    private router: Router) { }
  /**
   * Este metodo llama al metodo del servicio que dado un id, muestra todos los detalles de un libro. 
   * De ser fallida la operacion muestra un toast con el mensaje de error
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
        this.volver();
      }
    );
  }
  /**
   * Este metodo regresa a la pagina principal una vez se oprima el boton
   */
  volver(): void {
    this.router.navigate(['/']);
  }

}

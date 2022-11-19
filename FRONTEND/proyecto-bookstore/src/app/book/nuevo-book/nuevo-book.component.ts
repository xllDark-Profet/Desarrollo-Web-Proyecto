import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/service/book.service';
import { Book } from 'src/app/models/book';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/service/editorial.service';


@Component({
  selector: 'app-nuevo-book',
  templateUrl: './nuevo-book.component.html',
  styleUrls: ['./nuevo-book.component.css']
})


export class NuevoBookComponent implements OnInit {
  /**
   * Arreglo donde se van a guardar las editoriales que pueden ser seleccionadas al momento de crear un libro
   */
  editorials:Editorial[] = [];
  /**
   * Inicializacion de los atributos de un libro 
   */
  nombre = '';
  descripcion = '';
  cantidad: number = 0;
  editorial = '';
  imagen_url = '';
  dia_edicion = '';
  /**
   * Constructor del componente
   * @param bookService 
   * @param editorialService 
   * @param toastr 
   * @param router 
   */

  constructor(
    private bookService: BookService,
    private editorialService: EditorialService,
    private toastr: ToastrService,
    private router: Router
    ) { }
/**
 * Se cargan las editoriales disponibles 
 */
  ngOnInit() {

    this.cargarEditorials();
    
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio de editorial que entrega la lista de las editoriales.
   * Si la operacio nfalla se imprime en consola el mensaje de error. 
   */
  cargarEditorials(): void{
    this.editorialService.editoriallist().subscribe(
      data =>{
        this.editorials = data; 
      },
      err => {
        console.log(err);
      }
    )
  }
  /**
   * Este metodo se encarga de llamar al metodo del servicio que crea un nuevo libro dados todos los atributos de este. 
   * Si la operacion es exitosa , se muestra un toast confirmando el resultado de la operacion y se redirige a la table. 
   * Por el contrario si no es exitosa, se muestra un toast que indica que hubo un error 
   */
  onCreate(): void {
    const book = new Book(this.nombre, this.descripcion, this.cantidad, this.editorial, this.imagen_url, this.dia_edicion)
    this.bookService.save(book).subscribe(
      data => {
        this.toastr.success('Libro creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/book-table']);
      },
      err => {
        this.toastr.error(err.error.message, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/book-table']);
      }
    );
  }

}

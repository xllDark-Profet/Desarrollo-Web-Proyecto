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

  editorials:Editorial[] = [];
  
  nombre = '';
  descripcion = '';
  cantidad: number = 0;
  editorial = '';
  imagen_url = '';
  dia_edicion = '';


  constructor(
    private bookService: BookService,
    private editorialService: EditorialService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {

    this.cargarEditorials();
    
  }

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

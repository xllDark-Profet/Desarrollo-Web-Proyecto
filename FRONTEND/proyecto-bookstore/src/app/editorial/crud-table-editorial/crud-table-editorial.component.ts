import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/service/editorial.service';

@Component({
  selector: 'app-crud-table-editorial',
  templateUrl: './crud-table-editorial.component.html',
  styleUrls: ['./crud-table-editorial.component.css']
})
export class CrudTableEditorialComponent implements OnInit {
  
  /**
   * Arreglo donde se va a guardar cada una de las editoriales de la base de datos
   */
  editorials: Editorial[] = [];
  /**
   * Constructor del componente
   * @param editorialService 
   * @param http 
   * @param toastr 
   * @param router 
   */
  constructor(
    private editorialService: EditorialService, 
    private http: HttpClient, 
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
    this.cargarEditoriales();
  }
  /**
   * Este metodo llama al metodo del servicio que lista todas las editoriales de la libreria. 
   * Si la operacion no es exitosa se imprime el error en consola 
   */
  cargarEditoriales(): void{
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
   * Este metodo se encarga de llamar al metodo del servicio que elimina una editorial dado un id. Si la operacion es exitosa 
   * se muestra un mensaje con dicho resultado en un toast y se redirige a la tabla. 
   * De lo contrario se muestra un toast indicando que la operacion fallo. 
   * @param id 
   */
  borrar(id?: number){
    if (id != undefined){
      this.editorialService.delete(id).subscribe(
        data => {
          this.toastr.success('Producto Eliminado','OK', {
            timeOut: 3000,
            positionClass: 'toast-top-center'
          });
          this.router.navigate(['/editorial-table']);
          this.cargarEditoriales;
          
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

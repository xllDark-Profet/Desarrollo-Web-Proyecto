import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/service/editorial.service';

@Component({
  selector: 'app-editar-editorial',
  templateUrl: './editar-editorial.component.html',
  styleUrls: ['./editar-editorial.component.css']
})
export class EditarEditorialComponent implements OnInit {

  /**
   * Este atributo va a guardarla editorial que se va a editar
   */
  editorial!: Editorial;
  /**
   * Constructor del componente
   * @param editorialService 
   * @param activatedRoute 
   * @param toastr 
   * @param router 
   */
  constructor(
    private editorialService: EditorialService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }
  /**
   * Este metodo  llama al metodo del servicio que dado un id devuelve una editorial. EN caso de que la operacion no sea 
   * exitosa se muestra un mensaje en un toast de que fallo y se redirige a la tabla 
   */
  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.editorialService.editorialdetail(id).subscribe(
      data => {
        this.editorial = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/editorial-table']);
      }
    );
  }
  /**
   * Este metodo llama al metodo del servicio que dado un id y una editorial modifica los atributos de la correspondiente al id.
      Si se puede actualizar correctamente se muestra un toast con un mensjae de exito de la informacion y se redirige a la tabla. 
      De lo contrario, se muestra un toast con el mensaje de error y se redirige a la tabla 
  */
  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.editorialService.update(id, this.editorial).subscribe(
      data => {
        this.toastr.success('Editorial Actualizada', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/editorial-table']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/editorial-table']);
      }
    );
  }

}

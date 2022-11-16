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
  editorials: Editorial[] = [];

  constructor(
    private editorialService: EditorialService, 
    private http: HttpClient, 
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
    this.cargarEditoriales();
  }

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
